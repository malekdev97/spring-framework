package com.backend.backend.controller;

import com.backend.backend.dto.AuthResponseDto;
import com.backend.backend.dto.ForgotPasswordDto;
import com.backend.backend.dto.LoginDto;
import com.backend.backend.dto.RegisterDto;
import com.backend.backend.dto.ResetPasswordDto;
import com.backend.backend.entity.Role;
import com.backend.backend.entity.User;
import com.backend.backend.repository.RoleRepository;
import com.backend.backend.security.JwtGenerator;
import com.backend.backend.service.AuthService;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;

import net.bytebuddy.utility.RandomString;


@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${frontend.url}")
    private String frontendUrl;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AuthService authService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody User user){
        try {
            authService.save(user);
        }
         catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
         }
         catch (MethodArgumentNotValidException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
         }
         catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         }

        return ResponseEntity.ok("User registered successfully!");  
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
    
        SecurityContextHolder.getContext().setAuthentication(authentication);
    
        String token = jwtGenerator.generateToken(authentication);
    
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = authService.findByUsername(userDetails.getUsername());
    
        // Assuming that AuthResponseDto has fields for role and email
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setTokenType(token);
        authResponseDto.setRole(user.getRole().get(0).getName());
        authResponseDto.setEmail(user.getEmail());
        authResponseDto.setName(user.getName());
        long id = user.getId().longValue();
        authResponseDto.setId(id);
        // Set other fields as necessary
    
        // return token, user id, role and email
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

    // This method does not belong to the controller, meanwhile it should be in a service
    public void sendEmail(String recipientEmail, String link) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("no-repy@ameen.sa", "Forgot Password");
        helper.setTo(recipientEmail);

        String subject = "Reset password link";
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, or you have not made the request.</p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);

    }

    
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto, HttpServletRequest request) {

        // String 
        String email = forgotPasswordDto.getEmail();
        String token = RandomString.make(30);

        // take date now for the resset password token
        // user.resetPasswordTokenExpires = new Date(); // 2024/3/7:10

        try {
            authService.updateResetPasswordToken(token, email);

            // https://ameen-taupe.vercel.app/login-actions/reset-password?token=
            String resetPasswordLink = frontendUrl + "/login-actions/reset-password?token=" + token;
            // String resetPasswordLink = Utility.getSiteURL(request) + "/api/auth/reset-password?token=" + token; // generate reset password link

            sendEmail(email, resetPasswordLink);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while sending email");
        }

        return ResponseEntity.ok("We have sent a reset password link to your email. Please check your email.");

    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(HttpServletRequest request, @RequestParam String token, @RequestBody ResetPasswordDto resetPasswordDto) {
        // String token = request.getParameter("token");
        

        User user = authService.getByResetPasswordToken(token);
        if(token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        // chack expred password token
        // user.resetPasswordTokenExpires - new Date() > 30000

        if(user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        } else {
            user.setPassword(passwordEncoder.encode(resetPasswordDto.getPassword()));
            user.setResetPasswordToken(null);
            try {
                authService.save(user);
            } catch (MethodArgumentNotValidException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return ResponseEntity.ok("Password updated successfully");
        }
    }

    @GetMapping("/get-forgot-password-token")
    public ResponseEntity<String> getForgotPasswordToken(@RequestParam String token) {

        User user = authService.findByResetPasswordToken(token);
        
        if(user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        } else {
            return ResponseEntity.ok("Valid token");
        }
    }
}

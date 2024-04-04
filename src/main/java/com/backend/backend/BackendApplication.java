package com.backend.backend;

import com.backend.backend.entity.Role;
import com.backend.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication 
public class BackendApplication {

	@Autowired
	RoleRepository roleRepository;

	@Value("${frontend.url}")
    private String frontendUrl;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000", frontendUrl);
			}
		};
	}

	// Add default roles
	@Bean
	public void addDefaultRoles() {
		if(roleRepository.findByName("ADMIN").isPresent() || roleRepository.findByName("USER").isPresent()) {
			return;
		}
		Role role = new Role();
		role.setName("ADMIN");
		roleRepository.save(role);
		Role role1 = new Role();
		role1.setName("USER");
		roleRepository.save(role1);
	}

}

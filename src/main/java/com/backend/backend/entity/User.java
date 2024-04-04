package com.backend.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, max=50, message="username must be between 3 and 50 characters")
    private String username;


    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	@Column(name = "password")
    private String password;

	@Size(min=2,max=100,message="Name must be between 3 and 100 characters")
    private String name;

    @Email(message="Please enter a valid email!")
	@Column(name ="email",unique=true)
    private String email;

    @Size(min=10, max=10, message="phone must be 10 digits")
	@Column(name = "phone", unique=true)
    private String phone;

    private Date createdAt;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(name = "reset_password_token_expires")
    private Date resetPasswordTokenExpires;
    
    // get the current date if the user is created
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    private Date updatedAt;

    // get the current date if the user is updated
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @Column(name = "number_of_employees")
    private int numberOfEmployees; // this attribute is not needed

    // why do we need these two attributes? startDate and endDate
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    // private String verificationToken; // updating the spring security is required

    // private Date verifiedAt; // updating the spring security is required

    // private String passwordResetToken; // updating the spring security is required

    // private String resetTokenExpires; // updating the spring security is required

    // create join table user_role 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> role = new ArrayList<>(); // roles has a many to many relationship with the users

    // licenses has a many to one relationship with the users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id")
    private License license;

    // industries has a many to one relationship with the users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industrys_id")
    private Industry industry;

    // branchs has a many to one relationship with the users
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Branch branch;
    // this is not needed due to already having a many to many relationship with the roles + users
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "role_id")
    // private Role role;



}

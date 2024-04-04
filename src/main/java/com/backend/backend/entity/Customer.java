package com.backend.backend.entity;

import java.util.Date;
//import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
//	@NotEmpty(message="Customer name is required!")
	@Size(min=2, max=60, message="Customer name must be between 2 and 60 characters")
	@Column(name = "name")
	private String name;
	
//	@NotNull
//	@NotEmpty(message="username is required!")
	@Size(min=2, max=60, message="username must be between 2 and 60 characters")
	@Column(name = "username", unique=true)
	private String username;
	
//	@NotNull
//	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	@Column(name = "email", unique=true)
	private String email;
	
//	@NotNull
//	@NotEmpty(message="phone is required!")
	@Size(min=10, max=10, message="phone must be 10 digits")
	@Column(name = "phone", unique=true)
	private String phone;
	
//	@NotNull
//	@NotEmpty(message="password is required!")
	@Size(min=8, max=50, message="password must be between 8 and 50 characters")
	@Column(name = "password")
	private String password;
	
//	@NotNull
//	@Column(name = "deleted")
//	private boolean deleted = false;
	
	@Column(name="created_at" ,updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@Column(name="updated_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
			
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date(); 
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
//	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
//    private List<Branch> branchs;


	
	
	

}

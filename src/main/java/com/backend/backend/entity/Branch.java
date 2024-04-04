package com.backend.backend.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name="branchs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
//	@NotEmpty(message="Branch name is required!")
	@Size(min=2, max=80, message="Branch name must be between 2 and 80 characters")
	@Column(name = "name")
	private String name;
	
//	@NotNull
//	@NotEmpty(message="city is required!")
	@Size(min=2, max=200, message="City name must be between 2 and 80 characters")
	@Column(name = "city")
	private String city;
	
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
		
	
}




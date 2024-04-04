package com.backend.backend.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name="license")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class License {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull(message="license name is required!")
//	@NotEmpty(message="license name is required!")
	@Size(min=1, message="license name must be at least 1 char")
//	@NotEmpty(message="license name is required!")
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	

//	@Column(name = "deleted")
//	private boolean deleted;
	
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

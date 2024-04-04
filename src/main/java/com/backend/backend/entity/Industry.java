package com.backend.backend.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name="industrys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Industry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
//	@NotEmpty(message="Industry name is required!")
	@Size(min=2, max=80, message="Industry name must be between 2 and 80 characters")
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
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




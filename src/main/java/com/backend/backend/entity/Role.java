package com.backend.backend.entity;
// <<<<<<< HEAD

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	// assign By default to User
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min=1, message="role name must be at least 1 char")
	@Column(name = "name")
	private String name;


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
	
//	@NotNull
//	@NotEmpty(message="role is required!")
// @Enumerated(EnumType.STRING)
//	@Column(name = "role" )
//	private String role;


//	private String name;
}




//=======
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;


//@Entity
//@Data
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String name;
//}


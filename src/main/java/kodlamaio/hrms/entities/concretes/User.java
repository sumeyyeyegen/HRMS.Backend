package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")

public class User {
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="email", nullable = false, length = 320, unique = true)
	private String email;
	
	@Column(name="password",nullable = false, length = 25)
	private String password;
}

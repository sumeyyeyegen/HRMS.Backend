package kodlamaio.hrms.core.entities;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="users")

public class User {
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	
	@UniqueElements
	@Column(name="email")
	private String email;
	 
	@Column(name="user_password")
	private String password;
	
}

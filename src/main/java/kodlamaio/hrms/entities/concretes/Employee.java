package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends User {	
	@Id
	@Column(name="id")
	@JsonIgnore()
	@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
	private int id;

	@Column(name="first_name",nullable = false,length = 35)
	private String first_name;
	
	@Column(name="last_name",nullable = false,length = 35)
	private String last_name;
}

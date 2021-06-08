package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","Employee"})
@EqualsAndHashCode(callSuper = false)

public class Employee extends User {	
	
	@Id
	@NotNull
	@JsonIgnore()
	@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
	private int id;

	@NotNull
	@Length(max = 35)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Length(max = 35)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@JsonIgnore()
	@OneToMany(mappedBy = "employee")
	private List<EmployeeConfirm> employeeConfirms ;
}

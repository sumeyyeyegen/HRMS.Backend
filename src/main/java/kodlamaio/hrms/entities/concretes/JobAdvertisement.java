package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employer_id", nullable = false)
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="job_description", nullable = false, length = 500)
	private String jobDescription;
	
	@Column(name="open_positions", nullable = false)
	private int openPositions;
	
	@Column(name="application_deadline", nullable = false, length = 50)
	private Date applicationDeadline;
	
	@Column(name="is_active", nullable = false)
	private boolean isActive;
	
	@Column(name="release_date", nullable = false, length = 50)
	private Date releaseDate;
	
}

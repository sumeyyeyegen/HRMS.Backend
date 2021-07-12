package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
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
	@Column(name="id")
	private int id;
	
	@NotNull
	@Length(max = 500)
	@Column(name="job_description")
	private String jobDescription;
	
	@NotNull
	@Column(name="open_positions")
	private int openPositions;
	
	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@NotNull
	@Column(name="release_date")
	private LocalDateTime releaseDate;
	
	@NotNull
	@Column(name="min_salary")
	private int minSalary;
	
	@NotNull
	@Column(name="max_salary")
	private int maxSalary;
	
	@ManyToOne(targetEntity = Employer.class, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne (targetEntity = City.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(targetEntity = Job.class ,cascade = CascadeType.MERGE)
	@JoinColumn(name = "job_id")
	private Job job; 
	
	@ManyToOne(targetEntity = WorkPlace.class,cascade = CascadeType.MERGE)
	@JoinColumn(name = "work_place_id")
	private WorkPlace workPlace;
	

	@ManyToOne(targetEntity = WorkTime.class,cascade = CascadeType.MERGE)
	@JoinColumn(name = "work_time_id")
	private WorkTime workTime;
}

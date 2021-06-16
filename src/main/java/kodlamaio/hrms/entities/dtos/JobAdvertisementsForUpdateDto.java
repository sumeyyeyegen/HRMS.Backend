package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class JobAdvertisementsForUpdateDto {
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
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
}

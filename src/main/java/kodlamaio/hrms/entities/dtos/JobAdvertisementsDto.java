package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@AllArgsConstructor

public class JobAdvertisementsDto {
	@JsonIgnore()
	private int id;
	private int jobId;
	private String jobDescription;
	private int openPositions;
	@JsonIgnore
	private boolean isActive=true;
	private LocalDateTime applicationDeadline;
	private LocalDateTime releaseDate;
	private int minSalary;
	private int maxSalary;
	@JsonIgnore 
	private int employerId=17;
	private int cityId;
	private int workPlaceId;
	private int workTimeId;
}

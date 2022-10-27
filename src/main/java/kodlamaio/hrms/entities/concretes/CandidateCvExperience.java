package kodlamaio.hrms.entities.concretes;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_experiences")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCvExperience {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;
	
	@NotNull
	@Column(name="start_date")
	private Timestamp startDate;
	
	@Column(name="quit_date")
	private Timestamp quitDate;
	
	@Column(name="work_place_id")
	private int workPlaceId;
	
	@NotNull
	@Column(name = "created_at",nullable = false, updatable = false)
	@CreationTimestamp
	private final LocalDateTime createAt = LocalDateTime.now();
	
	@ManyToOne(targetEntity = CandidateCv.class, optional = false)
	@JsonIgnore
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
	
	@NotNull
	@ManyToOne(targetEntity = Job.class, optional = false)
	@JoinColumn(name="job_id")
	private Job job;
	
	@NotNull
	@ManyToOne(targetEntity = WorkPlace.class, optional = false)
	@JoinColumn(name="work_place_id" , insertable=false, updatable=false)
	private WorkPlace workPlaces;
}

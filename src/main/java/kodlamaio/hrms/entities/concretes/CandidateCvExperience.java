package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvExperience {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@JoinColumn(name="candidate_cv_id")
	@ManyToOne
	private CandidateCv candidateCv;
	
	@NotNull
	@JoinColumn(name="job_id")
	@ManyToOne
	private Job job;
	
	@NotNull
	@Column(name="work_place_name", length = 50)
	private String workPlaceName;
	
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="quit_date")
	private LocalDate quitDate;
	
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createAt = LocalDateTime.now();
	
}

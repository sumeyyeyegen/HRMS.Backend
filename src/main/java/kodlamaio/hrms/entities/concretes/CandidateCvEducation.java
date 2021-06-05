package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name="candidate_cv_educations")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCvEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@JoinColumn(name="candidate_cv_id")
	@ManyToOne
	private CandidateCv candidateCv;
	
	@NotNull
	@Column(name="school_name", length = 100)
	private String schoolName;

	@NotNull
	@Column(name="department_name", length = 100)
	private String departmentName;
	
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createAt = LocalDateTime.now();
}

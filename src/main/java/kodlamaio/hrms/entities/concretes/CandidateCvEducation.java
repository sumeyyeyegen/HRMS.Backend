package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_educations")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","CandidateCv"})

public class CandidateCvEducation {
	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(max = 100)
	@Column(name="school_name")
	private String schoolName;

	@NotNull
	@Length(max = 100)
	@Column(name="department_name")
	private String departmentName;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	private LocalDate startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "created_at")
	private final LocalDateTime createAt = LocalDateTime.now(ZoneId.of("Asia/Istanbul"));
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
}

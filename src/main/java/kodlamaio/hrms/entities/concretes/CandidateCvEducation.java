package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="candidate_cv_educations")
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","CandidateCv"})

public class CandidateCvEducation {
	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;
	
	@NotNull
	@Length(max = 100)
	@Column(name="school_name")
	@Getter
	@Setter
	private String schoolName;

	@NotNull
	@Length(max = 100)
	@Column(name="department_name")
	@Getter
	@Setter
	private String departmentName;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	@Getter
	@Setter
	private LocalDate startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="graduation_date")
	@Getter
	@Setter
	private LocalDate graduationDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "created_at")
	@Getter
	private final LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Asia/Istanbul"));
	
	@JsonIgnore
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
}

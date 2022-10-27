package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_skills")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateCvSkill {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;
	
	@NotNull
	@Length(max = 100)
	@Column(name="skill_name")
	private String name;
	
	@NotNull
	@Column(name = "created_at",nullable = false, updatable = false)
	@CreationTimestamp
	private final LocalDateTime createAt = LocalDateTime.now();

	@JsonIgnore()
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
}

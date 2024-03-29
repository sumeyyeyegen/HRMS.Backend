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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_languages")
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","CandidateCv"})

public class CandidateCvLanguage {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lang_id")
	private int langId;
	
	@NotNull
	@Column(name="lang_name")
	private String languageName;
	
	@NotNull
	@Column(name="lang_level")
	private short languageLevel; 
	
	@NotNull
	@Column(name = "created_at",nullable = false, updatable = false)
	@CreationTimestamp
	private final LocalDateTime createAt = LocalDateTime.now();

	@JsonIgnore()
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="candidate_cv_id")
	private CandidateCv candidateCv;
}

package kodlamaio.hrms.entities.concretes;
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
@Table(name="candidate_cv_languages")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvLanguage {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	@NotNull
	private CandidateCv candidateCv;
	
	@NotNull
	@Column(name="language_name")
	private String languageName;
	
	@NotNull
	@Column(name="language_level")
	private short languageLevel; 
	
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createAt = LocalDateTime.now();
	
}

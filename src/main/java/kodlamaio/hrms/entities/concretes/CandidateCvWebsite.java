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
@Table(name="candidate_cv_web_sites")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvWebsite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_cv_id")
	@NotNull
	private CandidateCv candidateCv;
	
	@ManyToOne
	@JoinColumn(name="web_site_id")
	@NotNull
	private Website website;
	
	@NotNull
	@Column(name="address",length = 200)
	private String address;
	
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createAt = LocalDateTime.now();
}

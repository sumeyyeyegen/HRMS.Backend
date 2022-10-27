package kodlamaio.hrms.entities.concretes;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="web_sites")
@NoArgsConstructor
@AllArgsConstructor

public class Website {
	
	@Id
	@Column(name="web_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(max = 50)
	@Column(name="web_address_path")
	private String name;
	
	@NotNull
	@JsonIgnore()
	@OneToOne(mappedBy = "website",cascade = CascadeType.ALL)
	private CandidateCvWebsite candidateCvWebsite;
}

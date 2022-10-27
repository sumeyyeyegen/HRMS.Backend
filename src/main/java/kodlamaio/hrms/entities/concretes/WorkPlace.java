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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="work_places")
@NoArgsConstructor
@AllArgsConstructor

public class WorkPlace {
	@Id
	@Column(name="work_place_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Length(max = 100)
	@Column(name="work_place_name")
	private String name;

	@JsonIgnore()
	@OneToMany(mappedBy="workPlace",cascade = CascadeType.MERGE)
	private List<JobAdvertisement> jobAdvertisements;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "workPlaces", cascade = CascadeType.MERGE)
	private List<CandidateCvExperience> experiences;
}

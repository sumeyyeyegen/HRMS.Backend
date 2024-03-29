package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="work_times")
@NoArgsConstructor
@AllArgsConstructor

public class WorkTime {

	@Id
	@Column(name="work_time_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@NotNull
	@Length(max = 30)
	@Column(name="work_time_title")
	private String name;
	
	@JsonIgnore()
	@OneToMany(mappedBy="workTime",cascade = CascadeType.MERGE)
	private List<JobAdvertisement> jobAdvertisements;
}

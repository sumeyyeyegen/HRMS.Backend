package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CvExperienceForAddAndUpdateDto {
	@JsonIgnore
	private int id;
	private String firstName;
	private String lastName;
	private int jobId;
	private int candidateCvId;
	private String workPlaceName;
	private LocalDate startDate;
	private LocalDate quitDate;
	private final LocalDateTime createAt = LocalDateTime.now();
}

package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

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

public class CvSkillForAddDto {
	@JsonIgnore()
	private int id;
	private String name;
	private final LocalDateTime createAt = LocalDateTime.now();
	private int candidateCvId;
}

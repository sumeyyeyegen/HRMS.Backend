package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.CandidateCv;
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
public class CvLanguagesForAddDto {
	@JsonIgnore
	private int id;
	private String languageName;
	private short languageLevel;
	private int candidateCvId;
	private final LocalDateTime createAt = LocalDateTime.now();
}

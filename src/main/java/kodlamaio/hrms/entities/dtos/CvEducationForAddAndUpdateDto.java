package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CvEducationForAddAndUpdateDto {
	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String schoolName;
	@Getter
	@Setter
	private String departmentName;
	@Getter
	@Setter
	private LocalDate startDate;
	@Getter
	@Setter
	private LocalDate graduationDate;
	@Getter
	@Setter
	private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Asia/Istanbul"));
	@Getter
	@Setter
	private int candidateCvId;
}

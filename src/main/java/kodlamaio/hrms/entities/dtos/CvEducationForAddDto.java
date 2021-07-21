package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.fasterxml.jackson.annotation.JsonFormat;

import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvEducationForAddDto {
	private int id;
	private String schoolName;
	private String departmentName;
	private LocalDate startDate;
	private LocalDate graduationDate;
	private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Asia/Istanbul"));
	private int candidateCvId;
}

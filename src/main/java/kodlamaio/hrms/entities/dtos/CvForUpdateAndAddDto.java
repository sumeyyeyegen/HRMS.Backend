package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.concretes.CandidateCvEducation;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvForUpdateAndAddDto {

	private int id;
	private String coverLetter;
	private int educationId;
	private int experienceId;
	private int languageId;
	private int skillId;
	private int imageId;
	private int candidateId;

}

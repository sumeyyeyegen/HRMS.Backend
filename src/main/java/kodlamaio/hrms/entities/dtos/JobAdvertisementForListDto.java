package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
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

public class JobAdvertisementForListDto {
	@JsonIgnore
	private int id;
	private String companyName;
	private String title;
	private int openPositions;
	private LocalDateTime releaseDate;
	private LocalDateTime applicationDeadline;
	
	public JobAdvertisementForListDto(String companyName,String title,int openPositions,LocalDateTime releaseDate,LocalDateTime applicationDeadline) {
		this.companyName=companyName;
		this.title=title;
		this.openPositions=openPositions;
		this.releaseDate=releaseDate;
		this.applicationDeadline=applicationDeadline;
	}
}

package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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

public class JobAdvertisementForListDto {
	@NotBlank
	@Size(max = 255, min = 0)
	private String companyName;
	
	@NotBlank
	@Size(max = 255, min = 0)
	private String title;
	
	@Positive
	private int openPositions;
	
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime releaseDate;
	
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime applicationDeadline;
}

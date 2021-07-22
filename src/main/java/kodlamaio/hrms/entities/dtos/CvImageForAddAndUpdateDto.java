package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvImageForAddDto {
	private int id;
	private String imageUrl;
	private LocalDateTime createAt = LocalDateTime.now();
	private int candidateCvId;
}

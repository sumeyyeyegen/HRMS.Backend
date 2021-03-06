package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

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

public class CvWebSitesForAddAndUpdateDto {
	private int id;
	private String address;
	private int candidateCvId;
	private int websiteId;
}

package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobs")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Job {
	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title",nullable = false,length = 255)
	private String title;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user_id;
}

package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Employer;

public interface UserDao extends JpaRepository<User, Integer> {
	User getById(Integer id);
}

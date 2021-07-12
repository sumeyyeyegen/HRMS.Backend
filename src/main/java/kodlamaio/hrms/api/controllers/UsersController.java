package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

@CrossOrigin()
@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	public UserService userService;
	
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	public DataResult<User> login(@RequestBody User user) {
		return this.userService.login(user);
	}
}

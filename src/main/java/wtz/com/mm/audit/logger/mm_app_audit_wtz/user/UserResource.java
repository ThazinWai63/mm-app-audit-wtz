package wtz.com.mm.audit.logger.mm_app_audit_wtz.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	//GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable int id){
		
		return service.findOne(id);
		
	}

}
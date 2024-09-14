package wtz.com.mm.audit.logger.mm_app_audit_wtz.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
		
		User user = service.findOne(id);
		
		if(user==null) throw new UserNotFoundExcepton("id: " + id );
		
		return user;
		
	}
	
	//POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User savedUser = service.save(user);
		// location - header => created method /users/4 => /users/{id}
		// location - header /users/4 which is created response message
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId())
												.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	

}

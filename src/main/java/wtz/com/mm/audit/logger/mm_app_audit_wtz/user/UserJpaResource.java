package wtz.com.mm.audit.logger.mm_app_audit_wtz.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import wtz.com.mm.audit.logger.mm_app_audit_wtz.jpa.UserRepository;


@RestController
public class UserJpaResource {
	
	private UserRepository repository;
	
	public UserJpaResource( UserRepository repository) {
		this.repository = repository;
	}
	
	//GET /users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		
		return repository.findAll();
		
	}
	
//	@GetMapping("/users/{id}")
//	public User retrieveUserById(@PathVariable int id){
//		
//		User user = service.findOne(id);
//		
//		if(user==null) throw new UserNotFoundException("id: " + id );
//		
//		return user;
//		
//	}
	
	//POST /users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = repository.save(user);
		// location - header => created method /users/4 => /users/{id}
		// location - header /users/4 which is created response message
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId())
												.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id){
		repository.deleteById(id);
		
	}
	
	//HATEOAS
	//http://localhost:8084/users
	//EntityModel
	//WebMVCLinkBuilder
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUserByIdHATEOAS(@PathVariable int id){
		
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) throw new UserNotFoundException("id: " + id );
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
		
	}
	
	
	

}

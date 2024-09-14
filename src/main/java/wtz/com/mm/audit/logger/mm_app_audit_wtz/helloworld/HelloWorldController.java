package wtz.com.mm.audit.logger.mm_app_audit_wtz.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	// /hello-world
	@GetMapping(path="/hello-world")
	//@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World Endpoint Testing.";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Endpoint Testing.");
	}
	
	// Path Parameters
	// /users/{id}/todos{id} => /users/2/todos/200
	// /hello-wolrd/path-variable/{name}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Endpoint Testing for Path Variable, %s ", name));
	}

}

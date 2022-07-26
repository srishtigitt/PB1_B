package pb1b.payments.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pb1b.payments.users.dto.ResponseStructure;
import pb1b.payments.users.dto.Users;
import pb1b.payments.users.service.UserService;


@RestController
@RequestMapping("/api/")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseStructure<Users> saveUser(@RequestBody  Users users) {
		return userService.createUser(users);
	}
	
	@PutMapping("user")
	public ResponseStructure<Users> updateUser(@RequestBody Users student) {
		return userService.updateUser(student);
	}
	
	@GetMapping("user")
	public  ResponseStructure<Users> getUserById(@RequestParam String id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("user/all")
	public ResponseStructure<List<Users>> getALl() {
		return userService.getAllUser();
	}
	
	
	@DeleteMapping("user/{id}")
	public ResponseStructure<Users> deleteUser(@PathVariable  String id) {
		return userService.deleteUserById(id);
	}
		
}



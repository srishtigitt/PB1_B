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

/**
*
* User Controller (UserController class is used to add users,Retreive the users, Delete the users, Update the users )
*
* @author Venuu Maadhav V R
*
*/


@RestController
@RequestMapping("/api/")
public class UserController {

	/**
	 * UserController
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * saveUser (this is responsible to create users )
	 * @param users
	 * @return
	 */
	@PostMapping("user")
	public ResponseStructure<Users> saveUser(@RequestBody  Users users) {
		return userService.createUser(users);
	}
	
	/**
	* updateUser (this is responsible to update the users )
	* @param student
	* @return 
	*/
	@PutMapping("user")
	public ResponseStructure<Users> updateUser(@RequestBody Users student) {
		return userService.updateUser(student);
	}
	/**
	* getUserById (this is responsible to retrieve the users by their id )
	* @param id
	* @return user 
	*/
	@GetMapping("user")
	public  ResponseStructure<Users> getUserById(@RequestParam String id) {
		return userService.getUserById(id);
	}
	/**
	* getALl (this is responsible to retrieve all the users )
	*
	* @param all
	* @return 
	*/
	@GetMapping("user/all")
	public ResponseStructure<List<Users>> getALl() {
		return userService.getAllUser();
	}
	
	/**
	* deleteUser (this is responsible to delete the users by their id )
	* @param id
	* @return 
	* 
	*/
	@DeleteMapping("user/{id}")
	public ResponseStructure<Users> deleteUser(@PathVariable  String id) {
		return userService.deleteUserById(id);
	}
		
}



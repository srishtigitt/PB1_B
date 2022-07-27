package pb1b.payments.users.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pb1b.payments.users.dto.Users;
import pb1b.payments.users.repository.UserRepository;

/*
* UserDao class is used to perform CRUD operations.
* 
* @author Venuu Maadhav V R
*/

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	/*
	* 
	* saveUser is used to save the User
	* 
	*/
	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
	/*
	* 
	* updateUser is used to update the User
	* 
	*/
	public Users updateUser(Users user) {
		return userRepository.save(user);
	}
	/*
	* 
	* getAll is used to retrieve all the Users
	* 
	*/
	public List<Users> getAll() {
		return userRepository.findAll();
	}
	/*
	* 
	* getUserById is used to retrieve the User by their id
	* 
	*/
	public Users getUserById(String id) {
		Optional<Users> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	/*
	* 
	* deleteUserById is used to delete the User by their id
	* 
	*/
	public boolean deleteUserById(String id) {
		Users student = getUserById(id);
		if (student != null) {
			userRepository.delete(student);
			return true;
		}
		return false;
	}
	
}

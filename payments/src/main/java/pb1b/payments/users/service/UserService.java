package pb1b.payments.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.users.dao.UserDao;
import pb1b.payments.users.dto.ResponseStructure;
import pb1b.payments.users.dto.Users;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseStructure<Users> createUser(Users users) {

		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("data Created successfully");
		Users savedUser = userDao.saveUser(users);
		responseStructure.setData(savedUser);
		return responseStructure;
	}

	
	public ResponseStructure<Users> updateUser(Users users) {

		Users existStudent = userDao.getUserById(users.getLoginId());
		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		if (existStudent != null) {
			Users updatedStudent = userDao.updateUser(users);
			responseStructure.setData(updatedStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist to updated");
		}

		return responseStructure;
	}
	
	
	
	public ResponseStructure<Users> getUserById(String id) {
		Users existStudent = userDao.getUserById(id);
		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		if (existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data found");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist");
		}
		return responseStructure;
	}

	public ResponseStructure<Users> deleteUserById(String id) {
		ResponseStructure<Users> responseStructure = new ResponseStructure<Users>();
		boolean res = userDao.deleteUserById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist to delete");
		}
		return responseStructure;
	}

	public ResponseStructure<List<Users>> getAllUser() {
		ResponseStructure<List<Users>> responseStructure = new ResponseStructure<List<Users>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(userDao.getAll());
		responseStructure.setMessage("all user data");
		return responseStructure;
	}
	
	
	
}
package pb1b.payments.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.role.dao.RoleDao;
import pb1b.payments.role.dto.Role;
import pb1b.payments.users.dto.ResponseStructure;


@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public ResponseStructure<Role> createRole(Role role) {

		ResponseStructure<Role> responseStructure = new ResponseStructure<Role>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("data Created successfully");
		Role createRole = roleDao.saveRole(role);
		responseStructure.setData(createRole);
		return responseStructure;
	}

//	public ResponseStructure<Role> updateRole(Role role) {
//
//		Role existRole = roleDao.getRoleById(role.getRoleId());
//		ResponseStructure<Role> responseStructure = new ResponseStructure<Role>();
//		if (existRole != null) {
//			Role updatedrole = roleDao.updateRole(role);
//			responseStructure.setData(updatedrole);
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Role data updated");
//		} else {
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("Role ID does not exist to updated");
//		}
//
//		return responseStructure;
//	}
//
//	public ResponseStructure<Role> getRoleById(String id) {
//		Role existStudent = roleDao.getRoleById(id);
//		ResponseStructure<Role> responseStructure = new ResponseStructure<Role>();
//		if (existStudent != null) {
//			responseStructure.setData(existStudent);
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Role data updated");
//		} else {
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("Role ID does not exist");
//		}
//		return responseStructure;
//	}
//
//	public ResponseStructure<Role> deleteRoleById(String id) {
//		ResponseStructure<Role> responseStructure = new ResponseStructure<Role>();
//		boolean res = roleDao.deleteUserById(id);
//		if (res) {
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Role data deleted");
//		} else {
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("Role ID does not exist to delete");
//		}
//		return responseStructure;
//	}
//
//	public ResponseStructure<List<Role>> getAllRole() {
//		ResponseStructure<List<Role>> responseStructure = new ResponseStructure<List<Role>>();
//		responseStructure.setStatus(HttpStatus.OK.value());
//		responseStructure.setData(roleDao.getAll());
//		responseStructure.setMessage("all Role data");
//		return responseStructure;
//	}

}

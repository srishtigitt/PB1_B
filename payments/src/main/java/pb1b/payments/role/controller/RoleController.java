package pb1b.payments.role.controller;

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

import pb1b.payments.role.dto.Role;
import pb1b.payments.role.service.RoleService;
import pb1b.payments.users.dto.ResponseStructure;



@RestController
@RequestMapping("/api/")
public class RoleController {

	@Autowired
	private RoleService roleservice;

	@PostMapping("Role")
	public ResponseStructure<Role> CreateRole(@RequestBody Role role) {
		return roleservice.createRole(role);
	
	}

//	@PutMapping("Role")
//	public ResponseStructure<Role> updateUser(@RequestBody Role student) {
//		return roleservice.updateRole(student);
//	}
//	
//	@GetMapping("Role")
//	public  ResponseStructure<Role> getRoleById(@RequestParam String id) {
//		return roleservice.getRoleById(id);
//	}
//	
//	@GetMapping("Role/all")
//	public ResponseStructure<List<Role>> getALl() {
//		return roleservice.getAllRole();
//	}
//	
//	
//	@DeleteMapping("user/{id}")
//	public ResponseStructure<Role> deleteUser(@PathVariable  String id) {
//		return roleservice.deleteRoleById(id);
//	}
//	

	
	
}
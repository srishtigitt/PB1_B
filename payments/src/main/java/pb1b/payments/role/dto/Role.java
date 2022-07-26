package pb1b.payments.role.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role_table")

public class Role {

	@Id
	@Column(nullable = false)
	private String RoleId;
	@Column(nullable = false)
	private String RoleName;

	public String getRoleId() {
		return RoleId;
	}

	public void setRoleId(String roleId) {
		RoleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

}

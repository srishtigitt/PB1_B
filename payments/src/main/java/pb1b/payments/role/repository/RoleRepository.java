package pb1b.payments.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.role.dto.Role;



public interface RoleRepository extends JpaRepository<Role,String> {

}

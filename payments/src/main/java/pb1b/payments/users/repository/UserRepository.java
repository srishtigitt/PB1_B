package pb1b.payments.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.users.dto.Users;



public interface UserRepository extends JpaRepository<Users, String> {

}

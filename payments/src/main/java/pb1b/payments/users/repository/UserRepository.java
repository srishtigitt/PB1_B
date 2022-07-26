package pb1b.payments.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.paymentsystem.user.dto.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}

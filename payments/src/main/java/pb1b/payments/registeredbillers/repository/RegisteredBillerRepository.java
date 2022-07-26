package pb1b.payments.registeredbillers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.registeredbillers.dto.RegisteredBillers;


public interface RegisteredBillerRepository extends JpaRepository<RegisteredBillers,String> {

}

package pb1b.payments.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.account.dto.Accounts;



public interface AccountRepository extends JpaRepository<Accounts,String>  {

}

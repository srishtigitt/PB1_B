package pb1b.payments.accounttransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.accounttransaction.dto.AccountTransaction;


public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,String>{

}

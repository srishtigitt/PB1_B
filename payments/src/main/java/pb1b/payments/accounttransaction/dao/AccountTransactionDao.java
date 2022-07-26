package pb1b.payments.accounttransaction.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pb1b.payments.accounttransaction.repository.AccountTransactionRepository;


@Repository
public class AccountTransactionDao {
	@Autowired
	private AccountTransactionRepository ATRepository;
	
	public AccountTransaction createAccountTransactions(AccountTransaction at) {
		return ATRepository.save(at);
	}
	
	public List<AccountTransaction> getAll(){
		return ATRepository.findAll();
	}

	
	public boolean deleteAccountTransactionById(String id) {
		AccountTransaction account = getAccountTransactionById(id);
		if (account != null) {
			ATRepository.delete(account);
			return true;
		}
		return false;
	}

	public AccountTransaction getAccountTransactionById(String id) {
		Optional<AccountTransaction> optional = ATRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	public AccountTransaction updateAccountTransaction(AccountTransaction account) {
		return ATRepository.save(account);
	}


	public AccountTransaction getAccountById(String id) {
		Optional<AccountTransaction> optional = ATRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
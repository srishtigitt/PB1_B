package pb1b.payments.accounttransaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.accounttransaction.dao.AccountTransactionDao;
import pb1b.payments.accounttransaction.dto.AccountTransaction;
import pb1b.payments.users.dto.ResponseStructure;


@Service
public class AccountTransactionService {
	@Autowired
	private AccountTransactionDao atDao;

	public ResponseStructure<AccountTransaction> createAccountTransactions(AccountTransaction at) {

		ResponseStructure<AccountTransaction> responseStructure = new ResponseStructure<AccountTransaction>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created data Successfully");
		AccountTransaction createAccountTransactions = atDao.createAccountTransactions(at);
		responseStructure.setData(createAccountTransactions);
		return responseStructure;
	}
	

	public ResponseStructure<AccountTransaction> deleteAccountTransactionsById(String id) {
		ResponseStructure<AccountTransaction> responseStructure = new ResponseStructure<AccountTransaction>();
		boolean res = atDao.deleteAccountTransactionById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Account Transaction data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Account Transaction does not exist to delete");
		}
		return responseStructure;
	}
	
	
	
	public ResponseStructure<AccountTransaction> updateAccountTransactions(AccountTransaction account) {

		AccountTransaction existAccount = atDao.getAccountTransactionById(account.getTransaction_Reference());
		ResponseStructure<AccountTransaction> responseStructure = new ResponseStructure<AccountTransaction>();
		if (existAccount != null) {
			AccountTransaction updatedAccount = atDao.updateAccountTransaction(account);
			responseStructure.setData(updatedAccount);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("AccountTransaction data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("AccountTransaction does not exist to updated");
		}

		return responseStructure;
	}

	public ResponseStructure<AccountTransaction> getAccountTransactionsById(String id) {
		AccountTransaction existStudent = atDao.getAccountTransactionById(id);
		ResponseStructure<AccountTransaction> responseStructure = new ResponseStructure<AccountTransaction>();
		if (existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("AccountTransaction data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("AccountTransaction does not exist");
		}
		return responseStructure;
	}


	public ResponseStructure<List<AccountTransaction>> getALlAccountTransactions() {
		ResponseStructure<List<AccountTransaction>> responseStructure = new ResponseStructure<List<AccountTransaction>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(atDao.getAll());
		responseStructure.setMessage("all AccountTransaction data");
		return responseStructure;
	}

}
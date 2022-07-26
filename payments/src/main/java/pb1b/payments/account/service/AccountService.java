package pb1b.payments.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.account.dao.AccountDao;
import pb1b.payments.account.dto.Accounts;
import pb1b.payments.users.dto.ResponseStructure;

/**
 * 
 * @author SRISHTI BAJAJ
 *
 */
@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	public ResponseStructure<Accounts> createAccount(Accounts account) {
		ResponseStructure<Accounts> responseStructure = new ResponseStructure<Accounts>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created account");
		Accounts savedUser = accountDao.CreateAccount(account);
		responseStructure.setData(savedUser);
		return responseStructure;
	}
	
	
	public ResponseStructure<Accounts> deleteAccountById(String id) {
		ResponseStructure<Accounts> responseStructure = new ResponseStructure<Accounts>();
		boolean res = accountDao.deleteUserById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist to delete");
		}
		return responseStructure;
	}
	
	
	
	public ResponseStructure<Accounts> updateAccount(Accounts account) {

		Accounts existAccount = accountDao.getAccountById(account.getSequence_ID());
		ResponseStructure<Accounts> responseStructure = new ResponseStructure<Accounts>();
		if (existAccount != null) {
			Accounts updatedAccount = accountDao.updateAccount(account);
			responseStructure.setData(updatedAccount);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist to updated");
		}

		return responseStructure;
	}

	public ResponseStructure<Accounts> getAccountById(String id) {
		Accounts existStudent = accountDao.getUserById(id);
		ResponseStructure<Accounts> responseStructure = new ResponseStructure<Accounts>();
		if (existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist");
		}
		return responseStructure;
	}


	public ResponseStructure<List<Accounts>> getALlAccount() {
		ResponseStructure<List<Accounts>> responseStructure = new ResponseStructure<List<Accounts>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(accountDao.getAll());
		responseStructure.setMessage("all student data");
		return responseStructure;
	}
}

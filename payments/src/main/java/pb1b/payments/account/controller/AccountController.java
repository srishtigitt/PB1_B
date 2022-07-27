package pb1b.payments.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pb1b.payments.account.dto.Accounts;
import pb1b.payments.account.service.AccountService;
import pb1b.payments.users.dto.ResponseStructure;
/**
*
* User Controller ( AccountController class is used to CreateAccount ,deleteAccount , updateAccount, getAccount By Id and get all accounts)
*
* @author SRISHTI BAJAJ
*
*/

@RestController
@RequestMapping("/api/")
public class AccountController {
	/**
	*
	* accountservices is used to Create ,delete, update, get Account By Id and get all accounts
	*
	*/
	@Autowired
	public AccountService accountservices;
	
	/**
	*
	* @param account
	* @return created account
	*/
	
	@PostMapping("Accounts")
	public ResponseStructure<Accounts> CreateAccount(@RequestBody Accounts account) {
		return accountservices.createAccount(account);
	}
	
	/**
	*
	* @param id
	* @return deleted account
	*/
	
	@DeleteMapping("Accounts/{id}")
	public ResponseStructure<Accounts> deleteAccount(@PathVariable  String id) {
		return accountservices.deleteAccountById(id);
	}
	
	/**
	*
	* @param account
	* @return updated account
	*/
	
	@PutMapping("Accounts")
	public ResponseStructure<Accounts> updateAccount(@RequestBody Accounts account) {
		return accountservices.updateAccount(account);
	}
	
	/**
	*
	* @param id
	* @return accounts
	*/
	
	@GetMapping("Accounts")
	public  ResponseStructure<Accounts> getAccountById(@RequestParam String id) {
		return accountservices.getAccountById(id);
	}
	
	/**
	*
	* @param
	* @return all account
	*/
	
	@GetMapping("Accounts/all")
	public ResponseStructure<List<Accounts>> getALlAccount() {
		return accountservices.getALlAccount();
	}
	
	
	//aryan
}

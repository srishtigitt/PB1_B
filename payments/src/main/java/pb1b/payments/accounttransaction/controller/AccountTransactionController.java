package pb1b.payments.accounttransaction.controller;


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

import pb1b.payments.accounttransaction.dto.AccountTransaction;
import pb1b.payments.accounttransaction.service.AccountTransactionService;
import pb1b.payments.users.dto.ResponseStructure;
/**
 * AccountTransactionController (In this AccountTransactionController class is used to add AccountTransaction,Retrieve the AccountTransaction, Delete the AccountTransaction, Update the AccountTransaction )
 * @author Sourav
 *
 */

@RestController
@RequestMapping("/api/")
public class AccountTransactionController {
	/**
	 * atrservice
	 */
	@Autowired
	private AccountTransactionService atrservice;
	
	/**
	 * CreateAccountTransaction (this is responsible to create AccountTransaction)
	 * @param accounttransaction
	 * @return
	 */
	@PostMapping("AccountTransactions")
	public ResponseStructure<AccountTransaction> CreateAccountTransaction(@RequestBody AccountTransaction accounttransaction) {
		return atrservice.createAccountTransactions(accounttransaction);
	}
	
	/**
	 * deleteAccountTransaction (this is responsible to delete AccountTransaction)
	 * @param accounttransactionid
	 * @return
	 */
	@DeleteMapping("AccountTransactions/{id}")
	public ResponseStructure<AccountTransaction> deleteAccountTransaction(@PathVariable  String accounttransactionid) {
		return atrservice.deleteAccountTransactionsById(accounttransactionid);
	}
	
	/**
	 * updateAccount (this is responsible to update AccountTransaction)
	 * @param account
	 * @return
	 */
	@PutMapping("AccountTransactions")
	public ResponseStructure<AccountTransaction> updateAccount(@RequestBody AccountTransaction account) {
		return atrservice.updateAccountTransactions(account);
	}
	
	/**
	 * getAccountTransactionsById (this is responsible to retrieve AccountTransaction using accounttransactionid)
	 * @param accounttransactionid
	 * @return
	 */
	@GetMapping("AccountTransactions")
	public  ResponseStructure<AccountTransaction> getAccountTransactionsById(@RequestParam String accounttransactionid) {
		return atrservice.getAccountTransactionsById(accounttransactionid);
	}
	
	/**
	 * getALlAccountTransactions (this is responsible to retrieve all AccountTransaction)
	 * @return
	 */
	@GetMapping("AccountTransactions/all")
	public ResponseStructure<List<AccountTransaction>> getALlAccountTransactions() {
		return atrservice.getALlAccountTransactions();
	}
	
	
	

}

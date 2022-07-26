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


@RestController
@RequestMapping("/api/")
public class AccountTransactionController {
	@Autowired
	private AccountTransactionService atrservice;
	
	@PostMapping("AccountTransactions")
	public ResponseStructure<AccountTransaction> CreateAccountTransaction(@RequestBody AccountTransaction at) {
		return atrservice.createAccountTransactions(at);
	}
	
	@DeleteMapping("AccountTransactions/{id}")
	public ResponseStructure<AccountTransaction> deleteAccountTransaction(@PathVariable  String id) {
		return atrservice.deleteAccountTransactionsById(id);
	}
	
	@PutMapping("AccountTransactions")
	public ResponseStructure<AccountTransaction> updateAccount(@RequestBody AccountTransaction account) {
		return atrservice.updateAccountTransactions(account);
	}
	
	@GetMapping("AccountTransactions")
	public  ResponseStructure<AccountTransaction> getAccountTransactionsById(@RequestParam String id) {
		return atrservice.getAccountTransactionsById(id);
	}
	
	@GetMapping("AccountTransactions/all")
	public ResponseStructure<List<AccountTransaction>> getALlAccountTransactions() {
		return atrservice.getALlAccountTransactions();
	}
	
	
	

}
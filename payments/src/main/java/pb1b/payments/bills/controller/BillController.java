package pb1b.payments.bills.controller;

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

import pb1b.payments.bills.dto.Bills;
import pb1b.payments.bills.service.BillService;
import pb1b.payments.users.dto.ResponseStructure;
/**
 *
 * RestController (This class is used to define post delete put and get mappings for bills )
 *
 * @author LOKENATH BASU
 *
 */
@RestController
@RequestMapping("/api/")
public class BillController {

/**
*
*
* billsservice is used to create,delete,update,fetch some or all bills 
*
*
*/
	
@Autowired
public BillService billsservice;

/**
*
* @param bill
* @return created bill
*/
@PostMapping("Bills")
public ResponseStructure <Bills> CreateBills( @RequestBody Bills bill){
	return billsservice.createBill(bill);
}

/**
*
* @param bill id
* @return deleted bill
*/
	
@DeleteMapping("Bills/{id}")
public ResponseStructure<Bills> deleteBill(@PathVariable  String id) {
	return billsservice.deleteBillsById(id);
}
	
/**
*
* @param bill
* @return updated bill
*/
	
@PutMapping("Bills")
public ResponseStructure<Bills> updateBill(@RequestBody Bills bi) {
	return billsservice.updateBill(bi);
}

/**
*
* @param id
* @return bill id
*/
	
@GetMapping("Bills")
public  ResponseStructure<Bills> getAccountById(@RequestParam String id) {
	return billsservice.getBillById(id);
}

/**
*
* @param id
* @return bills all
*/
	
@GetMapping("Bills/all")
public ResponseStructure<List<Bills>> getALlBill() {
	return billsservice.getALlBill();
}



}

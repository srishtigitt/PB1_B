package pb1b.payments.bills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.bills.dao.BillDao;
import pb1b.payments.bills.dto.Bills;
import pb1b.payments.users.dto.ResponseStructure;



@Service
public class BillService {

	
	@Autowired
	private BillDao billDao;

	public ResponseStructure<Bills> createBill(Bills bill) {

		ResponseStructure<Bills> responseStructure = new ResponseStructure<Bills>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved data");
		Bills createRole = billDao.CreateAccount(bill);
		responseStructure.setData(createRole);
		return responseStructure;
	}
	
	public ResponseStructure<Bills> deleteBillsById(String id) {
		ResponseStructure<Bills> responseStructure = new ResponseStructure<Bills>();
		boolean res = billDao.deleteBillById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Bills data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Bills ID does not exist to delete");
		}
		return responseStructure;
	}
	
	
	
	public ResponseStructure<Bills> updateBill(Bills bill) {

		Bills existAccount = billDao.getBillById(bill.getBillId());
		ResponseStructure<Bills> responseStructure = new ResponseStructure<Bills>();
		if (existAccount != null) {
			Bills updatedAccount = billDao.updateAccount(bill);
			responseStructure.setData(updatedAccount);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Bills data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Bills ID does not exist to updated");
		}

		return responseStructure;
	}

	public ResponseStructure<Bills> getBillById(String id) {
		Bills existStudent = billDao.getBillById(id);
		ResponseStructure<Bills> responseStructure = new ResponseStructure<Bills>();
		if (existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Bills data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Bills ID does not exist");
		}
		return responseStructure;
	}


	public ResponseStructure<List<Bills>> getALlBill() {
		ResponseStructure<List<Bills>> responseStructure = new ResponseStructure<List<Bills>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(billDao.getAll());
		responseStructure.setMessage("all Bills data");
		return responseStructure;
	}
	
	
	
	
	
	
}

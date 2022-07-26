package pb1b.payments.registeredbillers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.registeredbillers.dao.RegisterBillerDao;
import pb1b.payments.registeredbillers.dto.RegisteredBillers;
import pb1b.payments.users.dto.ResponseStructure;


@Service
public class RegisterBillerService {
	@Autowired
	private RegisterBillerDao registerbillerdao;

	public ResponseStructure<RegisteredBillers> createRegisteredBiller(RegisteredBillers rb) {

		ResponseStructure<RegisteredBillers> responseStructure = new ResponseStructure<RegisteredBillers>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved data");
		RegisteredBillers createRegisteredBiller = registerbillerdao.createRegisteredBiller(rb);
		responseStructure.setData(createRegisteredBiller);
		return responseStructure;
	}

	public ResponseStructure<RegisteredBillers> updateRegisteredBiller(RegisteredBillers rb) {

		RegisteredBillers existStudent = registerbillerdao.getRegisteredBillerById(rb.getBillerId());
		ResponseStructure<RegisteredBillers> responseStructure = new ResponseStructure<RegisteredBillers>();
		if (existStudent != null) {
			RegisteredBillers updatedRB = registerbillerdao.updateRegisteredBiller(rb);
			responseStructure.setData(updatedRB);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("RegisteredBiller  data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("RegisteredBiller ID does not exist to updated");
		}

		return responseStructure;
	}

	public ResponseStructure<RegisteredBillers> getRegisteredBillerById(String id) {
		RegisteredBillers existRB = registerbillerdao.getRegisteredBillerById(id);
		ResponseStructure<RegisteredBillers> responseStructure = new ResponseStructure<RegisteredBillers>();
		if (existRB != null) {
			responseStructure.setData(existRB);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("RegisteredBiller data found");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("RegisteredBiller ID does not exist");
		}
		return responseStructure;
	}

	public ResponseStructure<RegisteredBillers> deleteRegisteredBillerById(String id) {
		ResponseStructure<RegisteredBillers> responseStructure = new ResponseStructure<RegisteredBillers>();
		boolean res = registerbillerdao.deleteRegisteredBillerById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("RegisteredBiller data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("RegisteredBiller ID does not exist to delete");
		}
		return responseStructure;
	}

	public ResponseStructure<List<RegisteredBillers>> getAll() {
		ResponseStructure<List<RegisteredBillers>> responseStructure = new ResponseStructure<List<RegisteredBillers>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(registerbillerdao.getAll());
		responseStructure.setMessage("all RegisteredBiller data");
		return responseStructure;
	}

}
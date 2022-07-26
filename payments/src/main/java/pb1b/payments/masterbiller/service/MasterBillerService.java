package pb1b.payments.masterbiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pb1b.payments.masterbiller.dao.MasterBillerDao;
import pb1b.payments.masterbiller.dto.MasterBiller;
import pb1b.payments.users.dto.ResponseStructure;


@Service
public class MasterBillerService {
	@Autowired
	private MasterBillerDao masterbillerdao;

	public ResponseStructure<MasterBiller> createMasterBiller(MasterBiller masterbillerdao) {

		ResponseStructure<MasterBiller> responseStructure = new ResponseStructure<MasterBiller>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved data");
		MasterBiller createMasterBiller = masterbillerdao;
		responseStructure.setData(createMasterBiller);
		return responseStructure;
	}
	
	

	public ResponseStructure<MasterBiller> updateMasterBiller(MasterBiller masterbillera) {

		MasterBiller existStudent = masterbillerdao.getMasterBillerById(masterbillera.getBillerCode());
		ResponseStructure<MasterBiller> responseStructure = new ResponseStructure<MasterBiller>();
		if (existStudent != null) {
			MasterBiller Mb = masterbillerdao.updateMasterBiller(masterbillera);
			responseStructure.setData(Mb);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist to updated");
		}

		return responseStructure;
	}

	public ResponseStructure<MasterBiller> getMasterBillerById(String id) {
		MasterBiller existStudent = masterbillerdao.getMasterBillerById(id);
		ResponseStructure<MasterBiller> responseStructure = new ResponseStructure<MasterBiller>();
		if (existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data found");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist");
		}
		return responseStructure;
	}

	public ResponseStructure<MasterBiller> deleteMasterBillerById(String id) {
		ResponseStructure<MasterBiller> responseStructure = new ResponseStructure<MasterBiller>();
		boolean res = masterbillerdao.deleteMasterBillerById(id);
		if (res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("User ID does not exist to delete");
		}
		return responseStructure;
	}

	public ResponseStructure<List<MasterBiller>> getAllMasterBiller() {
		ResponseStructure<List<MasterBiller>> responseStructure = new ResponseStructure<List<MasterBiller>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(masterbillerdao.getAll());
		responseStructure.setMessage("all user data");
		return responseStructure;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
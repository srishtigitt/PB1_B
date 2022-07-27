package pb1b.payments.masterbiller.controller;

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

import pb1b.payments.masterbiller.dto.MasterBiller;
import pb1b.payments.masterbiller.service.MasterBillerService;
import pb1b.payments.users.dto.ResponseStructure;

/**
 * MasterBillerController ()
 * @author Pratiksha
 *
 */
@RestController
@RequestMapping("/api/")
public class MasterBillerController {
	/**
	 * masterbillerservice
	 */
	@Autowired
	private MasterBillerService masterbillerservice;

	/**
	 * CreateMasterBiller (this is responsible to create master bill)
	 * @param biller_Detail
	 * @return
	 */
	@PostMapping("MasterBiller")
	public ResponseStructure<MasterBiller> CreateMasterBiller(@RequestBody MasterBiller biller_Detail) {
		return masterbillerservice.createMasterBiller(biller_Detail);
	}
		
	/**
	 * updateMasterBiller (this is responsible to update master bill )
	 * @param Biller
	 * @return
	 */
	@PutMapping("MasterBiller")
	public ResponseStructure<MasterBiller> updateMasterBiller(@RequestBody MasterBiller Biller) {
		return masterbillerservice.updateMasterBiller(Biller);
	}
	
	/**
	 * getMasterBillerById (this is responsible to retrieve master bill )
	 * @param id
	 * @return
	 */
	@GetMapping("MasterBiller")
	public  ResponseStructure<MasterBiller> getMasterBillerById(@RequestParam String BillerCode) {
		return masterbillerservice.getMasterBillerById(BillerCode);
	}
	
	/**
	 * getALl (this is responsible to retrieve all master bills )
	 * @return
	 */
	@GetMapping("MasterBiller/all")
	public ResponseStructure<List<MasterBiller>> getALl() {
		return masterbillerservice.getAllMasterBiller();
	}
	
	/**
	 * deleteMasterBiller (this is responsible to delete master bill )
	 * @param id
	 * @return
	 */
	@DeleteMapping("MasterBiller/{id}")
	public ResponseStructure<MasterBiller> deleteMasterBiller(@PathVariable  String BillerCode) {
		return masterbillerservice.deleteMasterBillerById(BillerCode);
	}
	
	
	
}

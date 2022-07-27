package pb1b.payments.registeredbillers.controller;

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

import pb1b.payments.registeredbillers.dto.RegisteredBillers;
import pb1b.payments.registeredbillers.service.RegisterBillerService;
import pb1b.payments.users.dto.ResponseStructure;


@RestController
@RequestMapping("/api/")

/**
 * RegisterBillerController (Used to register, update, retreive and delete billers in the Registered_Billers table)
 * @author ARYAN
 *
 */ 


public class RegisterBillerController {
	/**
	 * RegisterBillerController
	 */
	@Autowired
	private RegisterBillerService registeredbillerservice;
	
	/**
	 * createRegisterBiller (this is responsible to create Register Biller)
	 * @param rb
	 * @return
	 */
	@PostMapping("RegisteredBiller")
	public ResponseStructure<RegisteredBillers> createRegisterBiller(@RequestBody RegisteredBillers rb) {
		return registeredbillerservice.createRegisteredBiller(rb);
	}
	/**
	 * updateStudent (this is responsible to update Registered Biller)
	 * @param RB
	 * @return
	 */
	@PutMapping("RegisteredBiller")
	public ResponseStructure<RegisteredBillers> updateStudent(@RequestBody RegisteredBillers RB) {
		return registeredbillerservice.updateRegisteredBiller(RB);
	}
	/**
	 * getRegisteredBillerById (this is responsible to retreive the Registered Biller by Id)
	 * @param id
	 * @return
	 */
	@GetMapping("RegisteredBiller")
	public ResponseStructure<RegisteredBillers> getRegisteredBillerById(@RequestParam String id) {
		return registeredbillerservice.getRegisteredBillerById(id);
	}
	/**
	 * getALl (this is responsible to retrieve all Registered Billers)
	 * @param all
	 * @return
	 */
	@GetMapping("RegisteredBiller/all")
	public ResponseStructure<List<RegisteredBillers>> getALl() {
		return registeredbillerservice.getAll();
	}
	/**
	 * deleteRegisteredBiller (this is responsible to delete the Registered Biller)
	 * @param id
	 * @return
	 */
	@DeleteMapping("RegisteredBiller/{id}")
	public ResponseStructure<RegisteredBillers> deleteRegisteredBiller(@PathVariable String id) {
		return registeredbillerservice.deleteRegisteredBillerById(id);
	}

}

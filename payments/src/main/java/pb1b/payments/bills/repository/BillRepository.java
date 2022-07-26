package pb1b.payments.bills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.bills.dto.Bills;
/**
 * 
 * @author LOKENATH BASU
 *
 */

public interface BillRepository extends JpaRepository<Bills,String> {

}

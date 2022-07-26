package pb1b.payments.bills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.bills.dto.Bills;


public interface BillRepository extends JpaRepository<Bills,String> {

}

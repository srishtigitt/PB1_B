package pb1b.payments.masterbiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pb1b.payments.masterbiller.dto.MasterBiller;


public interface MasterBillerRepository  extends JpaRepository<MasterBiller,String>{
}

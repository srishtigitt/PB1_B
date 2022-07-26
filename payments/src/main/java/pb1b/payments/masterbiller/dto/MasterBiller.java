package pb1b.payments.masterbiller.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Master_Biller")
public class MasterBiller {
	@Id
	@Column(nullable = false)
	private String BillerCode;
	@Column(name = "Name")
	private String BillerName;

	public String getBillerCode() {
		return BillerCode;
	}

	public void setBillerCode(String billerCode) {
		BillerCode = billerCode;
	}

	public String getBillerName() {
		return BillerName;
	}

	public void setBillerName(String billerName) {
		BillerName = billerName;
	}
	
	
	

}

package pb1b.payments.registeredbillers.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pb1b.payments.account.dto.Accounts;


@Entity
@Table(name = "Registered_Billers")
public class RegisteredBillers {
	@Id
	@Column(name = "Biller_ID", unique = true, nullable = false)
	private String BillerId;
//	@OneToOne
//	@JoinColumn(name = "Biller_Code", referencedColumnName = "BillerCode", unique = true, nullable = false)
//	private MasterBiller masterbiller;
	@Column(name = "ConsumerNumber", nullable = false)
	private String ConsumerNumber;
	@ManyToMany
	@JoinColumn(name = "AccountNumber", referencedColumnName = "Account_Number", nullable = false)
	Set<Accounts> accounts;
	@Column(name = "AutoPay", nullable = false)
	private Boolean AutoPay;
	@Column(name = "AutoPay_Limit", nullable = false)
	private Float AutoPay_Limit;

	public String getBillerId() {
		return BillerId;
	}

	public void setBillerId(String billerId) {
		BillerId = billerId;
	}

//	public MasterBiller getMasterbiller() {
//		return masterbiller;
//	}
//
//	public void setMasterbiller(MasterBiller masterbiller) {
//		this.masterbiller = masterbiller;
//	}

	public String getConsumerNumber() {
		return ConsumerNumber;
	}

	public void setConsumerNumber(String consumerNumber) {
		ConsumerNumber = consumerNumber;
	}

	public Boolean getAutoPay() {
		return AutoPay;
	}

	public void setAutoPay(Boolean autoPay) {
		AutoPay = autoPay;
	}

	public Float getAutoPay_Limit() {
		return AutoPay_Limit;
	}

	public void setAutoPay_Limit(Float autoPay_Limit) {
		AutoPay_Limit = autoPay_Limit;
	}

}

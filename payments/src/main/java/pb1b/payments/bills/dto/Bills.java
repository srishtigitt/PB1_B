package pb1b.payments.bills.dto;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pb1b.payments.registeredbillers.dto.RegisteredBillers;
/**
 * 
 * @author LOKENATH BASU
 *
 */


@Entity
@Table(name = "Bills_table")
public class Bills {
	@Id
	@Column(name="Bill_ID",unique=true,nullable=false)
	private String BillId;
	@ManyToMany
	@JoinColumn(name="Biller_Code", referencedColumnName="Biller_Code",nullable=false)
	@JoinColumn(name="ConsumerNumber", referencedColumnName="ConsumerNumber",nullable=false)
	Set<RegisteredBillers> registeredBillers;
	@Column(nullable = false)
    private Float Amount;
	@Column(nullable = false)
    private Boolean Status;
	@Column(nullable = false)
    private Date DueDate;
	public String getBillId() {
		return BillId;
	}
	public void setBillId(String billId) {
		BillId = billId;
	}
	public Set<RegisteredBillers> getRegisteredBillers() {
		return registeredBillers;
	}
	public void setRegisteredBillers(Set<RegisteredBillers> registeredBillers) {
		this.registeredBillers = registeredBillers;
	}
	public Float getAmount() {
		return Amount;
	}
	public void setAmount(Float amount) {
		Amount = amount;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	
	
	
	
	
}

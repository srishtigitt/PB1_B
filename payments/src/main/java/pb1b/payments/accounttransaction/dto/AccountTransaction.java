package pb1b.payments.accounttransaction.dto;

import javax.persistence.*;

import pb1b.payments.account.dto.Accounts;
import pb1b.payments.bills.dto.Bills;


@Entity
@Table(name = "AccountTransaction_table", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Transaction_Reference" }))
public class AccountTransaction {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Sequence_ID", referencedColumnName = "Sequence_ID", unique = true, nullable = false)
	private Accounts accounts;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Amount", referencedColumnName = "Amount", nullable = false)
	@JoinColumn(name = "Bill_Reference_Number", referencedColumnName = "Bill_ID", unique = true, nullable = false)
	private Bills bills;

	@Id
	private String Transaction_Reference;
	private String Time;

	@Column(nullable = false)
	private boolean Debit_Credit_status;

	private String Description;

	public AccountTransaction(Accounts accounts, Bills bills, String transaction_Reference, String time, float amount,
			boolean debit_Credit_status, String description) {
		super();
		this.accounts = accounts;
		this.bills = bills;
		Transaction_Reference = transaction_Reference;
		Time = time;
		Debit_Credit_status = debit_Credit_status;
		Description = description;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public String getTransaction_Reference() {
		return Transaction_Reference;
	}

	public void setTransaction_Reference(String transaction_Reference) {
		Transaction_Reference = transaction_Reference;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public boolean isDebit_Credit_status() {
		return Debit_Credit_status;
	}

	public void setDebit_Credit_status(boolean debit_Credit_status) {
		Debit_Credit_status = debit_Credit_status;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public AccountTransaction() {

	}

}

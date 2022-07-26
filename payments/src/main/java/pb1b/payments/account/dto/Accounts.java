package pb1b.payments.account.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_table")
public class Accounts {
	@Id
	private String Sequence_ID;
	@Column(nullable = false)
	private String Account_Number;
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private String Email_Address;
	@Column(nullable = false)
	private float Current_Balance;

	public Accounts() {

	}

	public String getSequence_ID() {
		return Sequence_ID;
	}

	public void setSequence_ID(String sequence_ID) {
		Sequence_ID = sequence_ID;
	}

	public String getAccount_Number() {
		return Account_Number;
	}

	public void setAccount_Number(String account_Number) {
		Account_Number = account_Number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail_Address() {
		return Email_Address;
	}

	public void setEmail_Address(String email_Address) {
		Email_Address = email_Address;
	}

	public float getCurrent_Balance() {
		return Current_Balance;
	}

	public void setCurrent_Balance(float current_Balance) {
		Current_Balance = current_Balance;
	}

	public Accounts(String sequence_ID, String account_Number, String name, String email_Address,
			float current_Balance) {
		super();
		Sequence_ID = sequence_ID;
		Account_Number = account_Number;
		Name = name;
		Email_Address = email_Address;
		Current_Balance = current_Balance;
	}

}

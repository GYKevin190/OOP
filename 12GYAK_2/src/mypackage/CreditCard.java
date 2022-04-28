package mypackage;

import java.time.LocalDate;

public class CreditCard extends Card {
	
	private int CreditLine;

	public CreditCard(String owner, LocalDate validity, CardIssuer issuer, int balance) {
		super(owner, validity, issuer, balance);
		this.setCreditLine(100000);
	}
	
	public CreditCard(String owner, LocalDate validity, CardIssuer issuer, int balance, int creditLine) {
		super(owner, validity, issuer, balance);
		this.setCreditLine(creditLine);
	}
	
	@Override
	public boolean Withdraw(int value) {
		int balanceBeforeOperation = super.getBalance();
		if (super.getBalance() > value){
			return super.Withdraw(value);
		}
		else if (super.getBalance() + CreditLine > value && super.Withdraw(balanceBeforeOperation)) {
			CreditLine -= value - balanceBeforeOperation;
		}
		return false;
	}
	
	@Override
	public boolean Charge() {
		int additionalFee = 0;
		switch (super.getIssuer()) {
		case CIB:
			additionalFee = 30;
		case ERSTE:
			additionalFee = 20;
		case KANDH:
			additionalFee = 15;
		case OTP:
			additionalFee = 10;
		}
		return this.Withdraw(additionalFee + super.getBalance());
	}

	@Override
	public String toString() {
		return "CreditCard [CreditLine=" + CreditLine + ", Owner=" + getOwner() + ", Validity="
				+ getValidity() + ", Issuer=" + getIssuer() + ", Balance=" + getBalance() + "]";
	}

	public int getCreditLine() {
		return CreditLine;
	}

	public void setCreditLine(int creditLine) {
		CreditLine = creditLine;
	}

}

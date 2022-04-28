package mypackage;

import java.time.LocalDate;

public class Card implements Comparable, Chargeable {
	private String owner;
	private LocalDate validity;
	private CardIssuer issuer;
	private int balance;
	private int usageFee;

	public int getUsageFee() {
		return usageFee;
	}

	public Card(String owner, LocalDate validity, CardIssuer issuer, int balance) {
		super();
		this.owner = owner;
		this.validity = validity;
		this.issuer = issuer;
		this.balance = balance;

		switch (issuer) {
		case CIB:
			usageFee = 70;
		case ERSTE:
			usageFee = 60;
		case KANDH:
			usageFee = 50;
		case OTP:
			usageFee = 30;
		}
	}

	public boolean Withdraw(int ammount) {
		if (ammount <= balance && LocalDate.now().isBefore(validity)) {
			balance -= ammount;
			return true;
		}
		return false;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	public CardIssuer getIssuer() {
		return issuer;
	}

	public void setIssuer(CardIssuer issuer) {
		this.issuer = issuer;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Card [owner=" + owner + ", validity=" + validity + ", issuer=" + issuer + ", balance=" + balance + "]";
	}

	@Override
	public int compareTo(Object o) {
		Card card = (Card) o;
		if (card.validity.isBefore(validity)) {
			return 1;
		} else if (card.validity.isAfter(validity)) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean Charge() throws NotEnoughBalanceForChargeFeeException {
		return this.Withdraw(usageFee);

	}

}

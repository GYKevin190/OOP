package mypackage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class CardTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//int n = ReadNumber();
		
		/*Card[] cards = new Card[n];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = ReadCard();
			
			Owner=Kiss Tamás, Valid=2020-04-30, Bank=OTP, Balance=150000, Credit=100000
Owner=Nagy Levente, Valid=2022-05-31, Bank=ERSTE, Balance=100000,
Owner=Szabó László, Valid=2019-03-31, Bank=OTP, Balance=200000, 
Owner=Kovács Edit, Valid=2021-01-31, Bank=CIB, Balance=250000 
			
			
		}*/
		
		Card[] cards = new Card[] {
				new CreditCard("Kiss Tamás", LocalDate.parse("2020-04-30"), CardIssuer.OTP, 150000, 100000),
				new Card("Nagy Levente", LocalDate.parse("2023-05-31"), CardIssuer.ERSTE, 100000),
				new CreditCard("Szabó László", LocalDate.parse("2019-03-31"), CardIssuer.OTP, 200000, 100000),
				new Card("Kovács Edit", LocalDate.parse("2023-01-31"), CardIssuer.CIB, 250000),
		};
		
		PrintCards(cards);

		int[] withdrawals = new int[] {280000, 80000, 50000, 100000};
		for (int i = 0; i < cards.length; i++) {
			Withdraw(i + 1, cards[i], withdrawals[i]);
		}
		
		System.out.println("CIB cards: " + CountCIBCards(cards));
		
		Arrays.sort(cards);

		PrintCards(cards);

		for (int i = 0; i < cards.length; i++) {
			try {
				cards[i].Charge();
			} catch (NotEnoughBalanceForChargeFeeException e) {
				System.out.println("Could not charge card with usage fee");
				e.printStackTrace();
			}
		}
		
		

	}

	private static void PrintCards(Card[] cards) {
		for (var card: cards) {
			System.out.println(card);
		}
	}
	
	public static void Withdraw(int withdrawIndex, Card card, int value) {
		if (card instanceof CreditCard)
		System.out.println(withdrawIndex + ". Penzfelvet: " + value + (card.Withdraw(value) ? "Sikeres" : "Sikertelen") + ", Uj egyenleg: " + card.getBalance() + ", Uj Credit: " + ((CreditCard)card).getCreditLine()) ;
		else
		System.out.println(withdrawIndex + ". Penzfelvet: " + value + (card.Withdraw(value) ? "Sikeres" : "Sikertelen") + ", Uj egyenleg: " + card.getBalance());
	}

	public static int ReadNumber() {
		System.out.println("Adjon meg 1 es 10 kozotti szamot");
		Integer n = null;
		while (true) {

			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
				if (n < 10 && n > 0) {
					scanner.nextLine();
					return n;
				} else {
					System.out.println("Rossz bemenet");
					scanner.nextLine();
				}
			} else {
				System.out.println("Rossz bemenet");
				scanner.nextLine();
			}
		}
	}

	public static Card ReadCard() {
		System.out.println(
				"Adja meg egy bankkarrtya adatait: 'tulajdonos, ervenyesseg:yyyy-MM-dd, Bank, Egyenleg, [Hitelkeret]'");

		while (true) {
			try {
				String input = scanner.nextLine();
				String[] segments = input.split(", ");
				
				String owner = segments[0];
				LocalDate expirity = LocalDate.parse(segments[1]);
				CardIssuer issuer = ParseIssuer(segments[2]);
				int balance = Integer.parseInt(segments[3]);
				Integer credit = segments.length > 4 ? Integer.parseInt(segments[4]) : null;

				return credit == null ? new Card(owner, expirity, issuer, balance)
						: new CreditCard(owner, expirity, issuer, balance, credit);

			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Rossz bemenet");
			}
		}

	}
	
	public static int CountCIBCards(Card[] cards) {
		int count = 0;
		for (Card card: cards) {
			if (card.getIssuer() == CardIssuer.CIB) {
				count++;
			}
		}
		return count;
	}

	private static CardIssuer ParseIssuer(String issuer) throws Exception {
		if (issuer.equalsIgnoreCase("K&H")) {
			return CardIssuer.KANDH;
		}
		for (var ci : CardIssuer.values()) {
			if (ci.toString().equalsIgnoreCase(issuer)) {
				return ci;
			}
		}

		throw new Exception("Uknown issuer");
	}

}

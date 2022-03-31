package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Run {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please give me the size of the array!");
		int N = readInt();
		product array[] = new product[N];
		fill(array);

		Arrays.sort(array, new Comparator<product>() {
			public int compare(product o1, product o2) {
				return o1.getPrice() - o2.getPrice();
			}

		});

		System.out.println("\n The array after sorting!");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		publisherWithMoreExpensiveBooks(array);

	}

	public static int readInt() {
		int beker = -1;
		do {
			while (!input.hasNextInt()) {
				System.out.println("Wrong input!");
				input.next();
			}
			beker = input.nextInt();
		} while (beker < 0);

		input.nextLine();
		return beker;
	}

	public static int readIntVat() {
		int beker = 0;
		do {
			if (beker < 0 || beker > 27) {
				System.out.println("Vat input is out of range(1-27)");
			}
			while (!input.hasNextInt()) {
				System.out.println("Wrong input!");
				input.next();
			}
			beker = input.nextInt();
		} while (beker <= 0 || beker > 27);

		input.nextLine();
		return beker;
	}

	public static String readString() {
		String beker = input.nextLine();
		return beker;
	}

	public static double readDouble() {
		double beker = -1;
		do {
			while (!input.hasNextDouble()) {
				System.out.println("Wrong input!");
				input.next();
			}
			beker = input.nextDouble();
		} while (beker < 0);

		input.nextLine();
		return beker;
	}

	public static void fill(product array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Please give me the " + (i + 1) + " product serialNumber!(1 if book 2 if bread)");
			int eldont = readInt();
			if (eldont == 1) {
				System.out.println("Please give the " + (i + 1) + " author!");
				String author = readString();
				System.out.println("Please give the " + (i + 1) + " title!");
				String title = readString();
				System.out.println("Please give the " + (i + 1) + " price!");
				int price = readInt();
				System.out.println("Please give the " + (i + 1) + " pages!");
				int pages = readInt();
				System.out.println("Please give the " + (i + 1) + " style!");
				String style = readString();
				array[i] = new Book(author, title, price, pages, style);
			} else {
				System.out.println("Please give the " + (i + 1) + " price!");
				int price = readInt();
				System.out.println("Please give the " + (i + 1) + " vat! between 1 and 27");
				int vat = readIntVat();
				System.out.println("Please give the " + (i + 1) + " unit!");
				double unit = readDouble();
				System.out.println("Please give the " + (i + 1) + " BreadName!");
				String name = readString();
				array[i] = new Bread(name, price, vat, unit);
			}

		}
	}

	public static void publisherWithMoreExpensiveBooks(product array[]) {

		Book[] books = new Book[array.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Book) {
				books[index] = (Book) array[i];
				index++;

			}
		}

		System.out.println("Authors with grater than 20Ft/page unit price:");
		String[] authors = new String[books.length];
		int wealthyAuthor = 0;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				boolean contain = containe(books[i], authors);
				if (!contain && books[i].getUnitPrice() > 20) {
					System.out.println(books[i].getAuthor());
					authors[wealthyAuthor] = books[i].getAuthor();
					wealthyAuthor++;
				}
			} else {
				break;
			}

		}
		if (wealthyAuthor == 0) {
			System.out.println("There were no authors that has books that cost 20Ft/page!");
		}
	}

	public static boolean containe(Book book, String[] books) {
		boolean contain = false;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null && books[i].equalsIgnoreCase(book.getAuthor())) {
				contain = true;
			}
		}
		return contain;
	}
}

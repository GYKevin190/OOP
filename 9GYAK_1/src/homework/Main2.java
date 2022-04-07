package homework;

import products.Book;
import products.Estate;
import products.ForSale;

public class Main2 {

	private static final int CHANGE = 260;

	public static void main(String[] args) {
		ForSale estate = new Estate(99999999, 255, "Tapolcai lakás");
		System.out.println(estate);
		Convert(estate);
		System.out.println(estate);
		Convert(estate);

		ForSale book = new Book("The lord of the rings", 260, 20);
		System.out.println(book);
		Convert(book);
		System.out.println(book);

	}

	public static void Convert(ForSale product) {
		if (product.getCurrency().equalsIgnoreCase("Ft")) {
			product.setPrice(product.getPrice() / CHANGE);
			product.setCurrency("Euro");
		} else if (product.getCurrency().equalsIgnoreCase("Euro")) {
			product.setPrice(product.getPrice() * CHANGE);
			product.setCurrency("Ft");
		}
	}

}
package products;

public class Book extends Product {
	public Book(String name, int nettoPrice, int vat) {
		super(name, nettoPrice, vat);
		super.setCurrency("Ft");
	}
}
package products;

public interface ForSale {

	int defaultPrice = 100;

	String getCurrency();

	void setCurrency(String currency);

	int getPrice();

	void setPrice(int price);
}
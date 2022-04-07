package products;

import java.awt.Color;
import colorable.Colorable;
import colorable.CustomColor;

public class Pen extends Product implements Colorable {

	CustomColor penColor;
	String brandName;

	public Pen(String brandName, Color penColor, int price) {
		super("pen", price, 27);
		this.brandName = brandName;
		this.penColor = new CustomColor(penColor);
	}

	@Override
	public String toString() {
		return "Pen [brand = " + brandName + ", color = " + penColor + ", price = " + this.grossPrice() + "]";
	}

	public Color getColor() {
		return penColor;
	}

	public void setColor(Color givenColor) {
		this.penColor = new CustomColor(penColor);
		;
	}

}
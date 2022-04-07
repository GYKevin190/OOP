package homework;

import java.awt.Color;
import colorable.Colorable;
import cordinates.Colored;
import products.Pen;

public class Main1 {

	public static void main(String[] args) {
		Colorable colorable = new Colored();
		System.out.println(colorable);
		colorable.setColor(Color.BLACK);
		System.out.println(colorable);

		Pen pen = new Pen("Pen", Color.BLUE, 200);
		System.out.println(pen);
		pen.setColor(Color.CYAN);
		System.out.println(pen);
	}
}
package cordinates;

import java.awt.Color;

import colorable.Colorable;

public class Colored extends Point implements Colorable {

	private Color newColor;

	public Colored() {
		super(0, 0);
		newColor = defaultColor;
	}

	Colored(Color newColor) {
		super(0, 0);
		this.newColor = newColor;
	}

	Colored(int x, int y, Color newColor) {
		super(x, y);
		this.newColor = newColor;
	}

	@Override
	public String toString() {
		return "x: " + this.getX() + ", y: " + this.getY() + ", color: " + newColor + "\n";
	}

	public Color getColor() {
		return newColor;
	}

	public void setColor(Color givenColor) {
		this.newColor = givenColor;
	}

}
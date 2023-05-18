package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Iterator;

import roomplanner.Object2D;

public class Wardrobe extends Object2D {

	private ArrayList<WardrobeElement> wardrobes;

	public Wardrobe(int amount) {
		xPosition = 120;
		yPosition = 150;
		colour = Color.BLUE;
		orientation = 0;
		isVisible = true;
		int wardrobeWidth = 110;
		width = wardrobeWidth * amount;
		height = 60;
		wardrobes = new ArrayList<WardrobeElement>(amount);
		for (int i = 0; i < amount; i++)
			wardrobes.add(new WardrobeElement(i * wardrobeWidth, 0, colour, orientation, wardrobeWidth, height));
		draw();
	}

	public Wardrobe(int x, int y, int amount) {
		xPosition = x;
		yPosition = y;
		colour = Color.BLUE;
		orientation = 0;
		isVisible = true;
		int wardrobeWidth = 110;
		width = wardrobeWidth * amount;
		height = 60;
		wardrobes = new ArrayList<WardrobeElement>(amount);
		for (int i = 0; i < amount; i++)
			wardrobes.add(new WardrobeElement(i * wardrobeWidth, 0, colour, orientation, wardrobeWidth, height));
		draw();
	}

  @Override
	protected Shape giveCurrentShape() {
		GeneralPath wardrobeWidth = new GeneralPath();
		for (Iterator<WardrobeElement> i = wardrobes.iterator(); i.hasNext();)
			wardrobeWidth.append(((WardrobeElement) i.next()).giveCurrentShape(), false);
		return transform(wardrobeWidth);
	}
}

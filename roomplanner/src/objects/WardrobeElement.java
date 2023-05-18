package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import roomplanner.Object2D;

public class WardrobeElement extends Object2D {

	public WardrobeElement() {
		xPosition = 120;
		yPosition = 150;
		colour = Color.BLUE;
		orientation = 0;
		isVisible = true;
		width = 110;
		height = 60;
		draw();
	}

	public WardrobeElement(int initX, int initY) {
		xPosition = initX;
		yPosition = initY;
		colour = Color.BLUE;
		orientation = 0;
		isVisible = true;
		width = 110;
		height = 60;
		draw();
	}

	protected WardrobeElement(int x, int y, String colour, int orientation, int width, int depth) {
		xPosition = x;
		yPosition = y;
		this.colour = colour;
		this.orientation = orientation;
		isVisible = true;
		this.width = width;
		height = depth;
		// no drawing as method is only used for Wardrobe class
	}

  @Override
	protected Shape giveCurrentShape() {
		GeneralPath wardrobe = new GeneralPath();
		Shape outline = new Rectangle2D.Double(0, 0, width, height);
		wardrobe.append(outline, false);
		wardrobe.moveTo(0, 0);
		wardrobe.lineTo(width, height);
		wardrobe.moveTo(0, height);
		wardrobe.lineTo(width, 0);
		return transform(wardrobe);
	}
}

package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import roomplanner.Object2D;

public class Table extends Object2D {

	public Table() {
		xPosition = 120;
		yPosition = 150;
		colour = Color.RED;
		orientation = 0;
		isVisible = true;
		width = 120;
		height = 80;
		draw();
	}

	public Table(int initX, int initY) {
		xPosition = initX;
		yPosition = initY;
		colour = Color.RED;
  	orientation = 0;
		isVisible = true;
		width = 120;
		height = 80;
		draw();
	}

  @Override
	protected Shape giveCurrentShape() {
		Shape table = new Rectangle2D.Double(0, 0, width, height);
		return transform(table);
	}
}

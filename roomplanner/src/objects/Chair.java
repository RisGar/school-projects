package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import roomplanner.Object2D;

public class Chair extends Object2D {
  public Chair() {
    xPosition = 160;
    yPosition = 80;
    colour = Color.BLUE;
    orientation = 0;
    isVisible = true;
    width = 45;
    height = 45;
    draw();
  }

  public Chair(int initX, int initY) {
    xPosition = initX;
    yPosition = initY;
    colour = Color.BLUE;
    orientation = 0;
    isVisible = true;
    width = 45;
    height = 45;
    draw();
  }

  @Override
  protected Shape giveCurrentShape() {
    GeneralPath chair = new GeneralPath();
    chair.moveTo(0, 0);
    chair.lineTo(width, 0);
    chair.lineTo(width + (width / 20 + 1), height);
    chair.lineTo(-(width / 20 + 1), height);
    chair.lineTo(0, 0);
    chair.moveTo(0, (width / 10 + 1));
    chair.lineTo(width, (width / 10 + 1));
    return transform(chair);
  }

}

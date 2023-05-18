package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;

import roomplanner.Object2D;

public class Bathtub extends Object2D {
  public Bathtub() {
    xPosition = 120;
    yPosition = 150;
    colour = Color.BLUE;
    orientation = 0;
    isVisible = true;
    width = 180;
    height = 80;
    draw();
  }

  public Bathtub(int initX, int initY) {
    xPosition = initX;
    yPosition = initY;
    colour = Color.BLUE;
    orientation = 0;
    isVisible = true;
    width = 180;
    height = 80;
    draw();
  }

  @Override
  protected Shape giveCurrentShape() {
    GeneralPath bathtub = new GeneralPath();
    Rectangle2D path = new Rectangle2D.Double(0, 0, width, height);
    bathtub.append(path, false);

    Line2D upper = new Line2D.Double(0.1 * height, 0.1 * height, width - 0.5 * height, 0.1 * height);
    Line2D left = new Line2D.Double(0.1 * height, 0.1 * height, 0.1 * height, 0.9 * height);
    Line2D lower = new Line2D.Double(0.1 * height, 0.9 * height, width - 0.5 * height, 0.9 * height);
    Arc2D arc = new Arc2D.Double(width - 0.9 * height, 0.1 * height, 0.8 * height, 0.8 * height, 270, 180, Arc2D.OPEN);

    bathtub.append(upper, false);
    bathtub.append(left, false);
    bathtub.append(lower, false);
    bathtub.append(arc, false);

    Ellipse2D drain = new Ellipse2D.Double(0.1 * width, 0.5 * height - 2, 4, 4);
    bathtub.append(drain, false);

    return transform(bathtub);
  }

}

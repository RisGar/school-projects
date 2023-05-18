package objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import roomplanner.Object2D;

public class RoundTable extends Object2D
{
    public RoundTable() {
        xPosition = 120;
        yPosition = 150;                       
        colour = Color.RED;
        orientation = 0;
        isVisible = true;
        width = 100;
        height  = 100;
        draw();
    }
    
    public RoundTable(int initX, int initY) {
        xPosition = initX;
        yPosition = initY;
        colour = Color.RED;
        orientation = 0;
        isVisible = true;
        width = 100;
        height  = 100;
        draw();
    }
    
  @Override
    protected Shape giveCurrentShape()
    {
        Shape table = new Ellipse2D.Double(0 , 0, width, height);
        return transform(table);
    }
}

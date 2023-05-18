package roomplanner;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;

public abstract class Object2D {
	protected int xPosition;
	protected int yPosition;
	protected int orientation;
	protected String colour;
	protected boolean isVisible;
	protected int width;
	protected int height;

	// Method overridden by each subclass to draw shape
	protected abstract Shape giveCurrentShape();

	protected final Shape transform(Shape path) {
		AffineTransform t = new AffineTransform();
		t.translate(xPosition, yPosition);
		Rectangle2D bounds = path.getBounds2D();
		t.rotate(Math.toRadians(orientation), bounds.getX() + bounds.getWidth() / 2,
			bounds.getY() + bounds.getHeight() / 2);
		return t.createTransformedShape(path);
	}

	public void show() {
		if (!isVisible) {
			isVisible = true;
			draw();
		}
	}

	public void hide() {
		erase();
		isVisible = false;
	}

	public void rotateTo(int angle) {
		erase();
		orientation = angle;
		draw();
	}

	public void rotateBy(int angle) {
		erase();
		orientation += angle;
		draw();
	}

	public void MoveX(int distance) {
		erase();
		Canvas.giveCanvas();
		if (distance > 0)
			xPosition += Math.min(distance, Canvas.width - xPosition - width - 1);
		else
			xPosition -= Math.min(Math.abs(distance), xPosition);
		draw();
	}

	public void MoveX() {
		erase();
		Canvas.giveCanvas();
		xPosition += Math.min(50, Canvas.width - xPosition - width - 1);
		draw();
	}

	public void MoveY(int distance) {
		erase();
		Canvas.giveCanvas();
		if (distance > 0)
			yPosition += Math.min(distance, Canvas.height - yPosition - height - 1);
		else
			yPosition -= Math.min(Math.abs(distance), yPosition);
		draw();
	}

	public void MoveY() {
		erase();
		Canvas.giveCanvas();
		yPosition += Math.min(50, Canvas.height - yPosition - height - 1);
		draw();
	}

	public void setPosition(int x, int y) {
		erase();
		xPosition = x;
		yPosition = y;
		draw();
	}

	public void changeColour(Color newColour) {
		erase();
		colour = newColour;
		draw();
	}

	public void scale(double factor) {
    width = (int) Math.round(width * factor);
    height = (int) Math.round(height * factor);
    draw();
  }

	public void changeSize(int widthNew, int heightNew) {
		erase();
		width = widthNew;
		height = heightNew;
		draw();
	}

	public void changeCanvasSize(int x, int y) { // TODO
		Canvas canvas = Canvas.giveCanvas();
		canvas.changeSize(x, y);
		canvas.wait(10);
	}

	protected void draw() {
		if (isVisible) {
			Shape shape = giveCurrentShape();
			Canvas canvas = Canvas.giveCanvas();
			canvas.draw(this, colour, shape);
			canvas.wait(10);
		}
	}

	protected void erase() {
		if (isVisible) {
			Canvas canvas = Canvas.giveCanvas();
			canvas.erase(this);
		}
	}
}

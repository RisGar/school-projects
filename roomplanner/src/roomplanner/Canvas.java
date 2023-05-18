package roomplanner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import static java.util.Map.entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas {

	private static Canvas canvasObject;

	public static int width = 1000;
	public static int height = 750;

	public static Canvas giveCanvas() {
		if (canvasObject == null) {
			canvasObject = new Canvas("Roomplanner", width, height, Color.white);
		}
		canvasObject.setVisibility(true);
		return canvasObject;
	}

	private JFrame frame;
	private CanvasPane canvas;
	private Graphics2D graphic;
	private Color backgroundColour;
	private Image canvasImage;
	private ArrayList<Object> objects;
	private HashMap<Object, ShapeDescription> shapes;

	// Singleton canvas instance
	private Canvas(String title, int width, int height, Color baseColour) {
		frame = new JFrame();
		canvas = new CanvasPane();
		frame.setContentPane(canvas);
		frame.setTitle(title);
		canvas.setPreferredSize(new Dimension(width, height));
		backgroundColour = baseColour;
		frame.pack();
		objects = new ArrayList<Object>();
		shapes = new HashMap<Object, ShapeDescription>();

	}

	private void setVisibility(boolean visible) {
		if (graphic == null) {
			Dimension size = canvas.getSize();
			canvasImage = canvas.createImage(size.width, size.height);
			graphic = (Graphics2D) canvasImage.getGraphics();
			graphic.setColor(backgroundColour);
			graphic.fillRect(0, 0, size.width, size.height);
			graphic.setColor(Color.black);
		}
		frame.setVisible(visible);
	}

	public void draw(Object referenceObject, String color, Shape shape) {
		objects.remove(referenceObject);
		objects.add(referenceObject);
		shapes.put(referenceObject, new ShapeDescription(shape, color));
		redraw();
	}

	public void erase(Object referenceObject) {
		objects.remove(referenceObject);
		shapes.remove(referenceObject);
		redraw();
	}

	public void setForegroundColor(Color colour) {
		graphic.setColor(colour);
	}

	public void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			// Ignoring exception at the moment
		}
	}

	private void redraw() {
		erase();
		for (Iterator<Object> i = objects.iterator(); i.hasNext();) {
			((ShapeDescription) shapes.get(i.next())).draw(graphic);
		}
		canvas.repaint();
	}

	private void erase() {
		Color original = graphic.getColor();
		graphic.setColor(backgroundColour);
		Dimension size = canvas.getSize();
		graphic.fill(new Rectangle(0, 0, size.width, size.height));
		graphic.setColor(original);
	}

	public void changeSize(int x, int y) {
		width = x;
		height = y;
		frame.dispose();
		canvasObject = null;
		Canvas canvas = giveCanvas();
		System.out.println(canvas);
		canvas.redraw();
		canvas.wait(10);
	}

	private class CanvasPane extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.drawImage(canvasImage, 0, 0, null);
		}
	}

	private class ShapeDescription {
		private Shape shape;
		private Color colour;

		public ShapeDescription(Shape shape, Color colour) {
			this.shape = shape;
			this.colour = colour;
		}

		public void draw(Graphics2D graphic) {
			setForegroundColor(colour);
			graphic.draw(shape);
		}
	}
}

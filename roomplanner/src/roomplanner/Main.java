package roomplanner;

import java.awt.Color;

import objects.Chair;
import objects.Table;
import objects.Wardrobe;

public class Main {

	public static void main(String[] args) {
		Canvas.giveCanvas();
		Table table = new Table();
		table.changeColour(Color.RED);
		Wardrobe wardrobe = new Wardrobe(300, 100, 3);
		wardrobe.MoveX(200);
		Chair chair = new Chair();
	}

}

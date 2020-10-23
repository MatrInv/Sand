package vues;

import java.awt.Color;

public class OurColor {
	private static final OurColor instance = new OurColor();
	public static Color sand = new Color(194,178,128);
	public static Color walls = Color.black;
	public static Color background = Color.white;
	
	//mapping between type numbers and colors
	//hopefully, mouse events types and the type we defined for the different elements are already well-mapped (left clic = sand type = 1 , right clic = walls type , ...)
	public static Color get(int type){
		switch (type){
			case 0:
				return background;
			case 1:
				return sand;
			case 2:	
				return walls;
		}
		assert true : "Mapping error !";
		return null; //ERROR
	}
}

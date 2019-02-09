import java.awt.BorderLayout;

import javax.swing.JFrame;

import modele.Modele;
import vues.Boutons;
import vues.Grille;

public class Main extends JFrame{
	
	public Main() {
		super("Sable");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Modele m = new Modele(80,80);
		Grille g = new Grille(m);
		Boutons b = new Boutons(m);
		
		this.add(BorderLayout.EAST, b);
		this.add(BorderLayout.CENTER, g);
		this.setVisible(true);
		
		
	
	}

	public static void main(String[] args) {
		Main m = new Main();
	}

}

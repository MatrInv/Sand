package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Modele;

public class Grille extends JPanel implements Observer {

	private Modele m;

	private JButton grille[][];

	private GridBagConstraints grid;

	private Color couleurs[] = { OurColor.background, OurColor.sand, OurColor.walls };

	private boolean pressed;

	private int buttonDown;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Grille(Modele mod) {
		super();

		pressed = false;

		m = mod;
		m.addObserver(this);

		this.setBorder(BorderFactory.createLineBorder(OurColor.walls, 12));

		grille = new JButton[m.getX()][m.getY()];

		this.setBackground(OurColor.background);
		this.setLayout(new GridBagLayout());
		grid = new GridBagConstraints();

		init();
	}

	public void init() {
		grid.gridy = 0;
		grid.gridx = 0;
		for (int x = 0; x < m.getX(); x++) {
			grid.gridx = x;
			for (int y = 0; y < m.getY(); y++) {
				grid.gridy = y;
				JButton c = new JButton();
				if (y >= m.getY() - 1 || y == 0 || x == 0 || x >= m.getX() - 1) {
					c.setBackground(OurColor.walls);
					m.setState(x, y, 2);
				} else {
					c.setBackground(OurColor.background);
				}
				c.setPreferredSize(new Dimension(5, 5));
				c.setBorderPainted(false);
				c.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						pressed = !pressed;
					}

					@Override
					public void mousePressed(MouseEvent e) {
						pressed = !pressed;
						buttonDown = e.getButton();
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						if (pressed)
							actionButton(e);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						actionButton(e);
					}

					public void actionButton(MouseEvent e) {
						int clicType;
						for (int x = 0; x < m.getX(); x++) {
							for (int y = 0; y < m.getY(); y++) {
								if ((JButton) e.getSource() == grille[x][y]) {
									clicType = detectClic(e);
									m.ajoutGrain(x, y, clicType);
									JButton b = (JButton) e.getSource();
									b.setBackground(OurColor.get(clicType));
								}
							}
						}
					}

					//Mapping between elements types and mouse events
					public int detectClic(MouseEvent e) {

						if (buttonDown == MouseEvent.BUTTON1) { // bouton gauche
							return 1;
						} else if (buttonDown == MouseEvent.BUTTON2) {// bouton milieu
							return 0;
						} else if (buttonDown == MouseEvent.BUTTON3) { // bouton droit
							return 2;
						}
						return 0;
					}
				});

				grille[x][y] = c;
				this.add(c, grid);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (int x = 0; x < m.getX(); x++) {
			for (int y = 0; y < m.getY(); y++) {
				grille[x][y].setBackground(couleurs[m.getState(x, y)]);
			}
		}
	}
}

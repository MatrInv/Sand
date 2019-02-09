package vues;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Modele;

public class Boutons extends JPanel implements Observer{
	
	private Modele m;
	private JButton play;
	private JButton reset;

	public Boutons(Modele mod) {
		super();
		
		m = mod;
		m.addObserver(this);

		play = new JButton("Play");
		
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mod.setPlay();
				m.playNext();
			}
		});
		
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.reset();
			}
		});
		this.add(reset);
		this.add(play);
		this.setLayout(new GridLayout(2,1));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(m.getPlay()) {
			play.setText("Pause");
		}else {
			play.setText("Play");
		}
	}

}

package vues;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Modele;

public class Boutons extends JPanel implements Observer{
	
	private Modele m;
	private JButton play;
	private JButton reset;
	private JButton method;
	private JLabel methodName;

	public Boutons(final Modele mod) {
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
		
		method = new JButton("Change Model");
		method.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.setMethod();
			}
		});
		
		methodName = new JLabel(m.getMethodName());
		
		this.add(reset);
		this.add(play);
		this.add(method);
		this.add(methodName);
		this.setLayout(new GridLayout(4,1));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(m.getPlay()) {
			play.setText("Pause");
		}else {
			play.setText("Play");
		}
		
		methodName.setText(m.getMethodName());
	}

}

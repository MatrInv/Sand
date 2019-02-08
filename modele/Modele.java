package modele;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Modele extends Observable {
	private Methode methode;
	private boolean play;

	private int couleurActu;

	public Modele(int x, int y) {
		methode = new Methode2(x, y);
		play = false;
		couleurActu = 1;
	}
	
	public boolean getPlay() {
		return play;
	}

	public void playNext() {
		 SwingWorker sw = new SwingWorker(){
		      protected Object doInBackground() throws Exception {
		        while(play) {
		        	methode.nextConfig();
		        	Thread.sleep(100);
		        	miseAJour();
		        }
				return null;
		      }
		         
		      public void done(){            
		      }         
		    };
		    sw.execute();
	}

	public Color ajoutGrain(int x, int y) {
		if (methode.getState(x, y) == 0) {
			methode.setState(x, y, 1);
			return Color.yellow;
		} else if (methode.getState(x, y) == 1) {
			methode.setState(x, y, 2);
			return Color.black;
		} else {
			methode.setState(x, y, 0);
			return Color.white;
		}
	}

	public int getX() {
		return methode.getX();
	}

	public int getY() {
		return methode.getY();
	}

	public int getState(int x, int y) {
		return methode.getState(x, y);
	}
	
	public void setState(int x, int y, int i) {
		methode.setState(x, y, i);
	}

	public void miseAJour() {
		setChanged();
		notifyObservers();
	}

	public void setPlay() {
		play = !play;
	}
}

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

	public Color ajoutGrain(int x, int y, int type) {
		
		if(x == getX()-1 || y == getY()-1 || x ==0 || y == 0 || type == 0) {
			setState(x, y, 2);
			return Color.black;
		}
		
		if ((getState(x, y) == 1 && type == 1) || (getState(x, y) == 2 && type == 2)) {
			methode.setState(x, y, 0);
			return Color.white;
		} else if (type == 1) {
			methode.setState(x, y, 1);
			return Color.yellow;
		} else {
			methode.setState(x, y, 2);
			return Color.black;
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

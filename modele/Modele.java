package modele;

import java.awt.Color;
import java.util.Observable;
import javax.swing.SwingWorker;

public class Modele extends Observable {
	private Methode methode;
	private boolean play;

	public Modele(int x, int y) {
		methode = new Methode2(x, y);
		play = false;
	}
	
	public void setMethod() {
		if (methode.getName().equals("Matyka's model")) {
			methode = new Methode1(getX(), getY());
		}else {
			methode = new Methode2(getX(), getY());
		}
		reset();
	}
	
	public String getMethodName() {
		return methode.getName();
	}
	
	public boolean getPlay() {
		return play;
	}
	
	public void reset() {
		play = false;
		methode.reset();
		miseAJour();
	}

	public void playNext() {
		 SwingWorker sw = new SwingWorker(){
		      protected Object doInBackground() throws Exception {
		        while(play) {
		        	methode.nextConfig();

		        	Thread.sleep(30);

		        	miseAJour();
		        }
				return null;
		      }
		         
		      public void done(){            
		      }         
		    };
		    sw.execute();
	}

	public void ajoutGrain(int x, int y, int type) {
		
		if (!(x == getX()-1 || y == getY()-1 || x ==0 || y == 0)) {
			methode.setState(x, y, type);
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

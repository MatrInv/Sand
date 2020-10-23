package modele;

public class Methode1 extends Methode {
	
	public Methode1(int x, int y) {
		super(x, y);
		
	}

	public void nextConfig() {
		int grilleNext[][] = new int[X][Y];
		grilleNext = clone(grille, grilleNext);
		for (int x = 1; x < X - 1; x++) {
			for (int y = 1; y < Y - 1; y++) {
				grilleNext[x][y] = nextState(x, y);
			}
		}
		
		grille = grilleNext;
	
	}

	public int nextState(int x, int y) {
		//double X = Math.random();
		
		if (getState(x, y) == 2) {
			return 2;
		}

		if (getState(x, y) == 0) {
			if (getState(x, y - 1) == 1) { // grain en haut
				return 1;
			} else if ( getState(x - 1, y - 1) == 1 && getState(x - 1, y) == 1 && getState(x, y-1) == 0 ) { // grains � gauche
				//if (X < 0.5)
					return 1;
			} else if ( getState(x + 1, y - 1) == 1 && getState(x + 1, y) == 1 && getState(x, y-1) == 0 ) { // grains � droite
				//if (X >= 0.5)
					return 1;
			}
		} else if (getState(x, y) == 1) {
			if (getState(x, y + 1) == 0) { // grain en haut
				return 0;
			} else if (getState(x, y + 1) == 1 && getState(x - 1, y + 1) == 0 && getState(x - 1, y) == 0) { // grains �																						// gauche
				return 0;
			} else if (getState(x, y + 1) == 1 && getState(x + 1, y + 1) == 0 && getState(x + 1, y) == 0) { // grains �																									// droite
				return 0;
			}
		}
		return getState(x, y);
	}

	@Override
	public String getName() {
		return "Our model";
	}

}

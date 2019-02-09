package modele;

public abstract class Methode {

	protected int X;
	protected int Y;

	protected int grille[][];

	public Methode(int x, int y) {
		X = x;
		Y = y;
		grille = new int[X][Y];

		for (int x1 = 0; x < X; x++) {
			for (int y1 = 0; y < Y; y++) {
				if (x1 == X - 1 || x1 == 0 || y1 == Y - 1 || y1 == 0) {
					grille[x1][y1] = 2;
				}
			}
		}

	}

	public abstract void nextConfig();

	public abstract String getName();

	public int getState(int x, int y) {
		return grille[x][y];
	}

	public void setState(int x, int y, int i) {
		grille[x][y] = i;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	/**
	 * clone tab dans tab2
	 * 
	 * @param tab
	 * @param tab2
	 * @return
	 */
	public int[][] clone(int[][] tab, int[][] tab2) {
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[0].length; y++) {
				tab2[x][y] = tab[x][y];
			}
		}
		return tab2;
	}

	public void reset() {
		for (int x = 0; x < X; x++) {
			for (int y = 0; y < Y; y++) {
				if (x == X - 1 || x == 0 || y == Y - 1 || y == 0) {
					grille[x][y] = 2;
				} else {
					grille[x][y] = 0;
				}
			}
		}
	}
}

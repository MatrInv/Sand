package modele;

public abstract class Methode {

	protected int X;
	protected int Y;

	protected int grille[][];

	public Methode(int x, int y) {
		X = x;
		Y = y;
		grille = new int[X][Y];
	}

	public abstract void nextConfig();

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
	 * @param tab
	 * @param tab2
	 * @return
	 */
	public int[][] clone(int[][] tab, int[][]tab2) {
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[0].length; y++) {
				tab2[x][y] = tab[x][y];
			}
		}
		return tab2;
	}
}

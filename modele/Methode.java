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
}

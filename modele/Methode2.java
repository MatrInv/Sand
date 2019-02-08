package modele;

public class Methode2 extends Methode{

	private int Imin, Imax, Jmin, Jmax;
	private int[][] next;
	private boolean stepParity = true;
	
	public Methode2(int x, int y) {
		super(x, y);
		next = new int[X][Y];
	}

	@Override
	public void nextConfig() {
		globalTransition();
		grille = next;
		next = new int[X][Y];
		stepParity = !stepParity;
	}

	public void init() {
		if(stepParity) {
			Imin=0; Imax=X-1; Jmin=0; Jmax=Y-1;
		}else {
			Imin=1; Imax=X-1; Jmin=1; Jmax=Y-1;
		}
	}
	
	public void localTransition(int x, int y) {
		double r;
		
		if(getState(x,y)==1 && getState(x+1,y)==1 && getState(x,y+1)==0 && getState(x+1,y+1)==0) {
			r=Math.random();
			if(r<0.5) {
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;
			}else {
				next[x][y] = getState(x, y);
				next[x+1][y] = getState(x+1, y);
				next[x][y+1] = getState(x, y+1);
				next[x+1][y+1] = getState(x+1, y+1);
			}
		
		}else {
			if(getState(x,y)==1 && getState(x+1,y)==0 && getState(x,y+1)==0 && getState(x+1,y+1)==0) {
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 0;

			}else if(getState(x,y)==0 && getState(x+1,y)==1 && getState(x,y+1)==0 && getState(x+1,y+1)==0){
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 0;
				next[x+1][y+1] = 1;

			}else if(getState(x,y)==0 && getState(x+1,y)==1 && getState(x,y+1)==1 && getState(x+1,y+1)==0){
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;

			}else if(getState(x,y)==1 && getState(x+1,y)==0 && getState(x,y+1)==0 && getState(x+1,y+1)==1){
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;

			}else if(getState(x,y)==1 && getState(x+1,y)==0 && getState(x,y+1)==1 && getState(x+1,y+1)==0){
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;

			}else if(getState(x,y)==0 && getState(x+1,y)==1 && getState(x,y+1)==0 && getState(x+1,y+1)==1){
				next[x][y] = 0;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;
				
			}else if(getState(x,y)==1 && getState(x+1,y)==1 && getState(x,y+1)==1 && getState(x+1,y+1)==0) {
				next[x][y] = 1;
				next[x+1][y] = 0;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;

			}else if(getState(x,y)==1 && getState(x+1,y)==1 && getState(x,y+1)==0 && getState(x+1,y+1)==1) {
				next[x][y] = 0;
				next[x+1][y] = 1;
				next[x][y+1] = 1;
				next[x+1][y+1] = 1;
				
			}else {
				next[x][y] = getState(x, y);
				next[x+1][y] = getState(x+1, y);
				next[x][y+1] = getState(x, y+1);
				next[x+1][y+1] = getState(x+1, y+1);

			}
		}
		
	}

	public void globalTransition() {
		//int t=0;
		//do {
			init();
			for(int j=Jmin;j<Jmax;j+=2) {
				for(int i=Imin;i<Imax;i+=2) {
					localTransition(i,j);
				}
			}
			
			//t++;
		//}while(t<tMax);
	}
	
	
}

package modele;

public class MethodeAmelioree extends Methode {

	private int Imin, Imax, Jmin, Jmax;
	private int[][] next;
	private int step = 0;
	private double P=0.6; //probabilite qu'un grain double tombe
	
	public MethodeAmelioree(int x, int y) {
		super(x, y);
		next = new int[X][Y];
	}

	@Override
	public void nextConfig() {
		globalTransition();
		grille = next;
		next = new int[X][Y];
		step = (step+1)%4;
	}

	public void init() {
		Imax=X-1; Jmax=Y-1;
		switch(step) { 
			case 0:
				Imin=1; Jmin=1;
				break;
			case 1:
				Imin=0; Jmin=0;
				break;
			case 2:
				Imin=1; Jmin=1;
				break;
			case 3:
				Imin=0; Jmin=0;
				break;
		}
	}
	
	public void localTransition(int x, int y) {
		double r;
		
		if(getState(x,y)==1 && getState(x+1,y)==1 && getState(x,y+1)==0 && getState(x+1,y+1)==0) {
			r=Math.random();
			if(r<P) {
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
		
		}else if( getState(x+1,y)==1 && getState(x+1,y+1)==0) {
			next[x][y] = getState(x,y);
			next[x+1][y] = 0;
			next[x][y+1] = getState(x,y+1);
			next[x+1][y+1] = 1;

		}else if( getState(x,y)==1 && getState(x,y+1)==0 ) {
			next[x][y] = 0;
			next[x+1][y] = getState(x+1,y);
			next[x][y+1] = 1;
			next[x+1][y+1] = getState(x+1,y+1);
			
		}else if(getState(x,y)==1 && getState(x+1,y)==0 && getState(x,y+1)==1 &&  getState(x+1,y+1)==0) {
				next[x][y] = 0;
				next[x+1][y] = getState(x+1,y);
				next[x][y+1] = getState(x,y+1);
				next[x+1][y+1] = 1;
				
		}else if(getState(x,y)==0 && getState(x+1,y)==1 && getState(x,y+1)==0 &&  getState(x+1,y+1)==1) {
			next[x][y] = getState(x,y);
			next[x+1][y] = 0;
			next[x][y+1] = 1;
			next[x+1][y+1] = getState(x+1,y+1);
			
		}else {
			next[x][y] = getState(x, y);
			next[x+1][y] = getState(x+1, y);
			next[x][y+1] = getState(x, y+1);
			next[x+1][y+1] = getState(x+1, y+1);

		}
	}

	public void globalTransition() {
		init();
		for(int j=Jmin;j<Jmax;j+=2) {
			for(int i=Imin;i<Imax;i+=2) {
				localTransition(i,j);
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Methode custom";
	}
	
}

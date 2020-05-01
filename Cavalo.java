public class Cavalo extends Peca{
	
	Cavalo (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean movimento (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		int horizontal = xFinal - xInicial;
		int vertical = yFinal - yInicial;
		
		if (horizontal == 1 && vertical == 2)
			return true;
		if (horizontal == -1 && vertical == 2)
			return true;
		if (horizontal == 1 && vertical == -2)
			return true;
		if (horizontal == -1 && vertical == -2)
			return true;
		if (horizontal == 2 && vertical == 1)
			return true;
		if (horizontal == 2 && vertical == -1)
			return true;
		if (horizontal == -2 && vertical == 1)
			return true;
		if (horizontal == -2 && vertical == -1)
			return true;
		return false;
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean p = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (p) {
			p = movimento (xInicial, xFinal, yInicial, yFinal, t);
		}
		return p;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean p = super.temCaptura (xInicial, xFinal, yInicial, yFinal,t);
		if (p) {
			p = movimento (xInicial, xFinal, yInicial, yFinal, t);
		}
		return p;
	}
}

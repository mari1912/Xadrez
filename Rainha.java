public class Rainha extends Peca{
	
	Rainha (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean movimento (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		if (xInicial == xFinal) { //se for andar na horizontal
			if (yInicial > yFinal) { //se for pra esquerda			
				int espacos = yInicial - yFinal;
				for (int i = 1; i < espacos; i++) {
					if (t[xInicial][yInicial - i].cor == '-')
						;
					else
						return false;
				}
			}
			else {
				int espacos = yFinal - yInicial;
				for (int i = 1; i < espacos; i++) {
					if (t[xInicial][yInicial + i].cor == '-')
						;
					else
						return false;
				}
			}
			return true;
		}
		else if (yInicial == yFinal) { //se for andar na horizontal
			if (xInicial > xFinal) { //se for pra baixo			
				int espacos = xInicial - xFinal;
				for (int i = 1; i < espacos; i++) {
					if (t[xInicial - i][yInicial].cor == '-')
						;
					else
						return false;
				}
			}
			else {
				int espacos = yFinal - yInicial;
				for (int i = 1; i < espacos; i++) { //pra cima
					if (t[xInicial + i][yInicial].cor == '-')
						;
					else
						return false;
				}
			}
			return true;
		}
		int horizontal = xFinal - xInicial;
		int vertical = yFinal - yInicial;
		if (vertical == horizontal) {
			if (vertical > 0) {
				for (int i = 1; i < vertical; i++) {
					if (t[xInicial + i][yInicial + i].cor == '-')
						;
					else
						return false;
				}
				return true;
			}
			else if (vertical < 0) {
				for (int i = vertical; i < 0; i++) {
					if (t[xInicial + i][yInicial + i].cor == '-')
						;
					else 
						return false;
				}
				return true;
			}
		}
		else if (vertical == -horizontal) {
			if (vertical > 0) {
				for (int i = 1; i < vertical; i++) {
					if (t[xInicial - i][yInicial + i].cor == '-')
						;
					else
						return false;
				}
				return true;
			}
			else if (vertical < 0) {
				for (int i = vertical; i < 0; i++) {
					if (t[xInicial - i][yInicial + i].cor == '-')
						;
					else
						return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean c = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (c) {
			c = movimento (xInicial, xFinal, yInicial, yFinal, t);
		}
		return c;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean c = super.temCaptura(xInicial, xFinal, yInicial, yFinal, t);
		if (c) {
			c = movimento (xInicial, xFinal, yInicial, yFinal, t);
		}
		return c;
	}
}

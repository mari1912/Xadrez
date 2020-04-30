public class Bispo extends Peca{
	
	Bispo (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean p = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (p) {
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
		}
		return false;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		return false;
	}
}

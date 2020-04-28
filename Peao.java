public class Peao extends Peca{
	
	Peao (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Tabuleiro t) {
		boolean b = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (b) {
			if (xInicial == xFinal) {
				if (t.tabuleiro[xInicial][yInicial].cor == 'b') {
					if (yFinal - yInicial == 1)
						return true;
					if (yFinal - yInicial == 2 && yFinal == 3 && t.tabuleiro[xInicial][yInicial + 1].cor == '-')
						return true;
				}
				else if (t.tabuleiro[xFinal][yFinal].cor == 'p') {
					if (yInicial - yFinal == 1)
						return true;
					if (yInicial - yFinal == 2 && yFinal == 4 && t.tabuleiro[xInicial][yInicial-1].cor == '-')
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Tabuleiro t) {
		boolean b = super.temCaptura(xInicial, xFinal, yInicial, yFinal, t);
		if (b) {
			if (t.tabuleiro[xInicial][yInicial].cor == 'b') {
				if (yFinal - yInicial == 2) {
					if (xFinal - xInicial == 2) {
						if (t.tabuleiro[xInicial + 1][yInicial + 1].cor == 'p')
							return true;
					}
					else if (xFinal - xInicial == -2) {
						if (t.tabuleiro[xInicial - 1][yInicial + 1].cor == 'p')
							return true;
					}
				}
			}
			else if (t.tabuleiro[xInicial][yInicial].cor == 'p') {
				if (yInicial - yFinal == 2) {
					if (xFinal - xInicial == 2) {
						if (t.tabuleiro[xInicial + 1][yInicial - 1].cor == 'b')
							return true;
					}
					else if (xFinal - xInicial == -2) {
						if (t.tabuleiro[xInicial-1][yInicial - 1].cor == 'b')
							return true;
					}
				}
			}
		}
		return false;
	}
	
	public void transforma() {
		;
	}
}

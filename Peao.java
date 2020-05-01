public class Peao extends Peca{
	
	Peao (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean b = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (b) {
			if (yInicial == yFinal) {
				if (t[xInicial][yInicial].cor == 'b') {
					if (xFinal - xInicial == 1)
						return true;
					if (xFinal - xInicial == 2 && xFinal == 3 && t[xInicial + 1][yInicial].cor == '-')
						return true;
				}
				else if (t[xInicial][yInicial].cor == 'p') {
					if (xInicial - xFinal == 1)
						return true;
					if (xInicial - xFinal == 2 && xFinal == 4 && t[xInicial - 1][yInicial].cor == '-')
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean b = super.temCaptura(xInicial, xFinal, yInicial, yFinal, t);
		if (b) {
			//tem que andar pra frente sempre
			if (t[xInicial][yInicial].cor == 'b') {
				if (xFinal - xInicial == 1) {
					if (yFinal - yInicial == 1 || yFinal - yInicial == -1)
						return true;
				}
			}
			else if (t[xInicial][yInicial].cor == 'p') {
				if (xFinal - xInicial == -1) {
					if (yFinal - yInicial == 1 || yFinal - yInicial == -1)
						return true;
				}
			}
		}
		return false;
	}
	
	public void transforma() {
		;
	}
}

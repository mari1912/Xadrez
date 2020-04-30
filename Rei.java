public class Rei extends Peca{

	Rei (String tipo, char cor) {
		super(tipo, cor);
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean p = super.podeMover (xInicial, xFinal, yInicial, yFinal, t);
		if (p) {
			//vertical frente e tras
			if (yInicial == yFinal) {
				if (xInicial - xFinal == 1 || xInicial - xFinal == -1)
					return true;
			}
			//horizontal direita e esquerda
			if (xInicial == xFinal) {
				if (yInicial - yFinal == 1 || yInicial - yFinal == -1)
					return true;
			}
			//diagonais nordeste, sudeste, sudoeste, noroeste
			if (xFinal - xInicial == 1 || xFinal - xInicial == -1) {
				if (yFinal - yInicial == 1 || yFinal - yInicial == -1)
					return true;
			}
		}
		return false;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		return false;
	}
}

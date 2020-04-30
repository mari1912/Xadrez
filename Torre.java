public class Torre extends Peca{

	Torre (String tipo, char cor) {
		super(tipo, cor);
	}
		
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean c = super.podeMover(xInicial, xFinal, yInicial, yFinal, t);
		if (c) {
			if (xInicial == xFinal) { //se for andar na horizontal
				System.out.println("ao");
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
				System.out.println("ei");
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
		}
		return false;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		boolean p = super.temCaptura(xInicial, xFinal, yInicial, yFinal, t);
		if (p) {
			if (xInicial == xFinal) { //se for andar na horizontal
				System.out.println("ao");
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
				System.out.println("ei");
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
		}
		return false;
	}
}

public class Peca {
	
	protected String tipo;
	protected char cor;
	
	Peca (String tipo, char cor) {
		this.tipo = tipo;
		this.cor = cor;
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Tabuleiro t) {
		if (xInicial > 7 || xInicial < 0)
			return false;
		if (xFinal > 7 || xFinal < 0)
			return false;
		if (yInicial > 7 || yInicial < 0)
			return false;
		if (yFinal > 7 || yFinal < 0)
			return false;
		if (t.tabuleiro[xInicial][yInicial].cor == '-')
			return false;
		if (t.tabuleiro[xFinal][yFinal].cor != '-')
			return false;
		return true;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Tabuleiro t) {
		if (xInicial > 7 || xInicial < 0)
			return false;
		if (xFinal > 7 || xFinal < 0)
			return false;
		if (yInicial > 7 || yInicial < 0)
			return false;
		if (yFinal > 7 || yFinal < 0)
			return false;
		if (t.tabuleiro[xInicial][yInicial].cor == '-')
			return false;
		if (t.tabuleiro[xFinal][yFinal].cor != '-')
			return false;
		return true;
	}
}

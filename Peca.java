public class Peca {
	
	protected String tipo;
	protected char cor;
	
	Peca (String tipo, char cor) {
		this.tipo = tipo;
		this.cor = cor;
	}
	
	public boolean podeMover (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		
		//a peca esta dentro dos limites do tabuleiro
		if (xInicial > 7 || xInicial < 0)
			return false;
		if (xFinal > 7 || xFinal < 0)
			return false;
		if (yInicial > 7 || yInicial < 0)
			return false;
		if (yFinal > 7 || yFinal < 0)
			return false;
		
		//a posicao inicial esta vazia
		if (t[xInicial][yInicial].cor == '-')
			return false;
		
		//a posicao final nao esta vazia
		if (t[xFinal][yFinal].cor != '-')
			return false;
		
		//se aposicao final e incial sao a mesma
		if (xFinal == xInicial && yFinal == yInicial)
			return false;
		
		return true;
	}
	
	public boolean temCaptura (int xInicial, int xFinal, int yInicial, int yFinal, Peca[][] t) {
		/*captura:
		 * a posicao final da peca deve conter a peca que deseja ser capturada
		 * a peca capturada tem que ser da cor oposta a peca que capturou
		 */
		
		//Se esta dentro do tabuleiro
		if (xInicial > 7 || xInicial < 0)
			return false;
		if (xFinal > 7 || xFinal < 0)
			return false;
		if (yInicial > 7 || yInicial < 0)
			return false;
		if (yFinal > 7 || yFinal < 0)
			return false;
		
		//se a posicao inicial e final esta vazia
		if (t[xInicial][yInicial].cor == '-')
			return false;
		if (t[xFinal][yFinal].cor == '-')
			return false;
		
		//se a peca na posicao final e da mesma cor que a peca da posicao inicial
		if (t[xInicial][yInicial].cor == t[xFinal][yFinal].cor)
			return false;
		
		//se a posicao inicial e final sao a mesma
		if (xInicial == xFinal && yInicial == yFinal)
			return false;
		
		return true;
	}
}

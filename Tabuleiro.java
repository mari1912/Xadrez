public class Tabuleiro {
	
	protected Peca[][] tabuleiro;
	protected char vez; //branco ou preto
	
	Tabuleiro () {
		
		tabuleiro = new Peca [8][8];
		vez = 'b'; //comeca com os brancos
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0) {
					if (j == 0 || j == 7)
						tabuleiro[i][j] = new Torre("torre", 'b');
					else if (j == 1 || j == 6)
						tabuleiro[i][j] = new Cavalo("cavalo", 'b');
					else if (j == 2 || j == 5)
						tabuleiro[i][j] = new Bispo("bispo", 'b');
					else if (j == 3)
						tabuleiro[i][j] = new Rainha("rainha", 'b');
					else
						tabuleiro[i][j] = new Rei("rei", 'b');				
				}
				else if (i == 1)
					tabuleiro[i][j] = new Peao("peao", 'b');
				else if (i == 7) {
					if (j == 0 || j == 7)
						tabuleiro[i][j] = new Torre("torre", 'p');
					else if (j == 1 || j == 6)
						tabuleiro[i][j] = new Cavalo("cavalo", 'p');
					else if (j == 2 || j == 5)
						tabuleiro[i][j] = new Bispo("bispo", 'p');
					else if (j == 4)
						tabuleiro[i][j] = new Rainha("rainha", 'p');
					else
						tabuleiro[i][j] = new Rei("rei", 'p');
				}
				else if (i == 6)
					tabuleiro[i][j] = new Peao ("peao", 'p');
				else {
					tabuleiro[i][j] = new Peca ("vazio", '-');
				}
			}
		}
	}
	
	public void imprime() {
		for (int i = 8; i > 0; i--) {
			System.out.print(i + "\t");
			for (int j = 0; j < 8; j++) {
				if (tabuleiro[i-1][j].cor == '-')
					System.out.print(tabuleiro[i-1][j].cor + "\t");
				else {
					if (tabuleiro[i-1][j].tipo == "torre") {
						if (tabuleiro[i-1][j].cor == 'p')
							System.out.print("T\t");
						else
							System.out.print("t" + "\t");
					}
					else if (tabuleiro[i-1][j].tipo == "cavalo") {
						if (tabuleiro[i-1][j].cor == 'p')
							System.out.print("H\t");
						else
							System.out.print("h\t");
					}
					else if (tabuleiro[i-1][j].tipo == "bispo") {
						if (tabuleiro[i-1][j].cor == 'p')
							System.out.print("B\t");
						else
							System.out.print("b\t");
					}
					else if (tabuleiro[i-1][j].tipo == "rainha") {
						if (tabuleiro[i-1][j].cor == 'p')
							System.out.print("Q\t");
						else
							System.out.print("q\t");
					}
					else if (tabuleiro[i-1][j].tipo == "rei") {
						if (tabuleiro[i-1][j].cor == 'p')
							System.out.print("K\t");
						else 
							System.out.print("k\t");
					}
					else {
						if (tabuleiro[i][j].cor == 'p')
							System.out.print("P\t");
						else
							System.out.print("p\t");
					}
				}
			}
			System.out.println("");
		}
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
	}
	
	public void vezDeQuem () {
		;
	}
	
	public void realizaMovimento () {
		;
	}
	
	public void realizaCaptura () {
		;
	}
}

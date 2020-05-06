public class Tabuleiro {
	
	protected Peca[][] tabuleiro;
	protected char vez; //branco ou preto
	protected int reis; 
	
	Tabuleiro () {
		
		tabuleiro = new Peca [8][8];
		vez = 'b'; //comeca com os brancos
		reis = 2;
		
		for (int i = 7; i >= 0; i--) {
			for (int j = 7; j >= 0; j--) {
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
			System.out.println("");
		}
	}
	
	public void imprime() {
		for (int i = 7; i >= 0; i--) {
			System.out.print((i+1) + "\t");
			for (int j = 0; j <= 7; j++) {
				if (tabuleiro[i][j].cor == '-')
					System.out.print(tabuleiro[i][j].cor + "\t");
				else {
					if (tabuleiro[i][j].tipo == "torre") {
						if (tabuleiro[i][j].cor == 'p')
							System.out.print("T\t");
						else
							System.out.print("t" + "\t");
					}
					else if (tabuleiro[i][j].tipo == "cavalo") {
						if (tabuleiro[i][j].cor == 'p')
							System.out.print("H\t");
						else
							System.out.print("h\t");
					}
					else if (tabuleiro[i][j].tipo == "bispo") {
						if (tabuleiro[i][j].cor == 'p')
							System.out.print("B\t");
						else
							System.out.print("b\t");
					}
					else if (tabuleiro[i][j].tipo == "rainha") {
						if (tabuleiro[i][j].cor == 'p')
							System.out.print("Q\t");
						else
							System.out.print("q\t");
					}
					else if (tabuleiro[i][j].tipo == "rei") {
						if (tabuleiro[i][j].cor == 'p')
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
	
	public boolean realizaMovimento (int xInicial, int xFinal, int yInicial, int yFinal) {
		boolean p = tabuleiro[xInicial][yInicial].podeMover(xInicial, xFinal, yInicial, yFinal, tabuleiro);
		if (p) {
			if (tabuleiro[xInicial][yInicial].tipo == "peao")
                                tabuleiro[xFinal][yFinal] = new Peao ("peao", tabuleiro[xInicial][yInicial].cor);
			else if (tabuleiro[xInicial][yInicial].tipo == "bispo")
				tabuleiro[xFinal][yFinal] = new Bispo ("bispo", tabuleiro[xInicial][yInicial].cor);
			else if (tabuleiro[xInicial][yInicial].tipo == "cavalo")
				tabuleiro[xFinal][yFinal] = new Cavalo ("cavalo", tabuleiro[xInicial][yInicial].cor);
			else if (tabuleiro[xInicial][yInicial].tipo == "torre")
				tabuleiro[xFinal][yFinal] = new Torre ("torre", tabuleiro[xInicial][yInicial].cor);
			else if (tabuleiro[xInicial][yInicial].tipo == "rainha")
				tabuleiro[xFinal][yFinal] = new Rainha ("rainha", tabuleiro[xInicial][yInicial].cor);
			else if (tabuleiro[xInicial][yInicial].tipo == "rei")
				tabuleiro[xFinal][yFinal] = new Rei ("rei", tabuleiro[xInicial][yInicial].cor);
			tabuleiro[xInicial][yInicial] = new Peca ("vazio", '-');
			return true;
		}
		else {
			p = tabuleiro[xInicial][yInicial].temCaptura(xInicial, xFinal, yInicial, yFinal, tabuleiro);
			if (p) {
				if (tabuleiro[xFinal][yFinal].tipo == "rei") //se um rei for eliminado
					reis--;
				if (tabuleiro[xInicial][yInicial].tipo == "peao")
					tabuleiro[xFinal][yFinal] = new Peao ("peao", tabuleiro[xInicial][yInicial].cor);
				else if (tabuleiro[xInicial][yInicial].tipo == "bispo")
					tabuleiro[xFinal][yFinal] = new Bispo ("bispo", tabuleiro[xInicial][yInicial].cor);
				else if (tabuleiro[xInicial][yInicial].tipo == "cavalo")
					tabuleiro[xFinal][yFinal] = new Cavalo ("cavalo", tabuleiro[xInicial][yInicial].cor);
				else if (tabuleiro[xInicial][yInicial].tipo == "torre")
					tabuleiro[xFinal][yFinal] = new Torre ("torre", tabuleiro[xInicial][yInicial].cor);
				else if (tabuleiro[xInicial][yInicial].tipo == "rainha")
					tabuleiro[xFinal][yFinal] = new Rainha ("rainha", tabuleiro[xInicial][yInicial].cor);
				else if (tabuleiro[xInicial][yInicial].tipo == "rei")
					tabuleiro[xFinal][yFinal] = new Rei ("rei", tabuleiro[xInicial][yInicial].cor);
				tabuleiro[xInicial][yInicial] = new Peca ("vazio", '-');
				return true;
			}
			return false;
		}
	}
	
	public boolean temJogo () {
		if (reis == 2)
			return true;
		else
			return false;
	}
	
	public boolean mover (char[] pos, int turno) {
		int xInicial = pos[1] - '1';
		int yInicial = pos[0] - 'a';
		int xFinal = pos[4] - '1';
		int yFinal = pos[3] - 'a';
		if (turno%2==0 && tabuleiro[xInicial][yInicial].cor == 'b') {
			// vez das pretas e o movimento indicado foi de uma peca branca
			return false;
		}
		if (turno%2==1 && tabuleiro[xInicial][yInicial].cor == 'p') {
			// vez das brancas e o movimento indicado foi de uma peca preta
			return false;
		}
		return realizaMovimento(xInicial, xFinal, yInicial, yFinal);
	}
		
	public void transformar(int xTransforma, int yTransforma, char type) {
		switch(type) {
			case 'q':
				tabuleiro[xTransforma][yTransforma] = new Rainha("rainha",tabuleiro[xTransforma][yTransforma].cor);
				break;
			case 'h':
                                tabuleiro[xTransforma][yTransforma] = new Cavalo("cavalo",tabuleiro[xTransforma][yTransforma].cor);
                                break;
			case 't':
                                tabuleiro[xTransforma][yTransforma] = new Torre("torre",tabuleiro[xTransforma][yTransforma].cor);
                                break;
			case 'b':
                                tabuleiro[xTransforma][yTransforma] = new Bispo("bispo",tabuleiro[xTransforma][yTransforma].cor);
                                break;
		}
	}
}

public class Main {

	public static void main (String[] args) {
		
		//variavel pra ver se o movimento realizado foi valido;
		boolean passaAVez;

		//variavel pra ver o turno;
		int turno = 1; // turno impar = vez das brancas; turno par = vez das pretas
		
		//array com os caracteres indicando a posicao das pecas que serao movidas
		char[] pos = new char[10];

		//Le o arquivo "arq002.csv"
		CSVReader csv = new CSVReader();
		csv.setDataSource("arq002.csv");
		Command commands[] = csv.requestCommands();

		//Cria o tabuleiro;
		Tabuleiro tabuleiro = new Tabuleiro();
		System.out.println("Tabuleiro inicial:");
		tabuleiro.imprime();
		
		
		//Fazer os movimentos
		for (int i=0;i<commands.length;i++) {
			if (commands[i] instanceof Mover) {
				pos = commands[i].getCommand().toCharArray();
				passaAVez = tabuleiro.mover(pos, turno);
				if (passaAVez) {
					turno++;
					if (i<commands.length-1 && commands[i+1] instanceof Transformar) {
						int xTransforma = commands[i].getCommand().charAt(4) - '1';
                                		int yTransforma = commands[i].getCommand().charAt(3) - 'a';
                                		char type = commands[i+1].getCommand().charAt(0);
                                		tabuleiro.transformar(xTransforma,yTransforma,type);
						i++;
					}
					System.out.printf("Source: %c%c\n", pos[0], pos[1]);
					System.out.printf("Target: %c%c\n", pos[3], pos[4]);
					tabuleiro.imprime();
				}
				if (!tabuleiro.temJogo()) {
					System.out.println("Fim de jogo");
					break;
				}
			}
		}
	}
}

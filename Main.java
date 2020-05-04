public class Main {

	public static void main (String[] args) {
		
		//variavel pra ver se o movimento realizado foi valido;
		boolean passaAVez;

		//variavel pra ver o turno;
		int turno = 1; // turno impar = vez das brancas; turno par = vez das pretas
		
		//array com os caracteres indicando a posicao das pecas que serao movidas
		char[] pos = new char[10];

		//Le o arquivo "arq001.csv"
		CSVReader csv = new CSVReader();
		csv.setDataSource("arq001.csv");
		String commands[] = csv.requestCommands();
		

		//Cria o tabuleiro;
		Tabuleiro tabuleiro = new Tabuleiro();
		System.out.println("Tabuleiro inicial:");
		tabuleiro.imprime();
		
		
		//Fazer os movimentos
		for (int i=0;i<commands.length;i++) {
			pos = commands[i].toCharArray();
			passaAVez = tabuleiro.mover(pos, turno);
			if (passaAVez) {
				turno++;
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

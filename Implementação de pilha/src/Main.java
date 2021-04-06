import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		Operacoes operacoes = new Operacoes();
		TipoPilhaConteiner pilha1 = new TipoPilhaConteiner();
		TipoPilhaConteiner pilha2 = new TipoPilhaConteiner();

		pilha1.init();
		pilha2.init();

		int opcao;
		do {
			System.out.println(Operacoes.menu());
			opcao = ler.nextInt();

			if (opcao > 6 || opcao < 0)
				System.out.println("NÚMERO INVÁLIDO, POR FAVOR DIGITE NOVAMENTE!");
			else 
			{
				switch (opcao) {
				case 1:
					operacoes.inserirConteiner(pilha1, pilha2);
					break;
				case 2:
					operacoes.retiraContainerDaPilha(pilha1, pilha2);
					break;
				case 3:
					operacoes.movimentacoes();
					break;
				case 4:
					operacoes.apresentacaoContainers(pilha1, pilha2);
					break;
				case 5:
					operacoes.apresentacaoPilhas();
					break;
				}
			}

			System.out.println("\n");
		} while (opcao != 0);
		
		ler.close();
	}

	

	


	

	

	

	

	

}

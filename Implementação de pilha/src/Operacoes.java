import java.util.Scanner;

public class Operacoes {

	private Scanner ler = new Scanner(System.in);
	private int[] idContainers1 = new int[4];
	private int[] idContainers2 = new int[4];
	private int posicao1 = 0;
	private int posicao2 = 0;
	public int movimentacaoGlobal = 0;
	
	
	//Métodos de operações!
	public static String menu() {
		String aux = "Escolha uma operação: \n";
		aux += "0 - Encerrar programa \n";
		aux += "1 - Insere conteiner no pátio \n";
		aux += "2 - Retira conteiner do pátio \n";
		aux += "3 - Cálculo do custo da movimentação dos conteiners \n";
		aux += "4 - Apresenta os conteiners em cada pilha do pátio \n";
		aux += "5 - Apresenta planilhas de conteineres de cada pilha do pátio \n";
		aux += "Opção: ";

		return aux;
	}
	public void inserirConteiner(TipoPilhaConteiner pilha1, TipoPilhaConteiner pilha2) {
		
		System.out.println("Informe o código de identificação do container: ");
		int identificacao = ler.nextInt();

		Container container = new Container(identificacao);

		if (pilha1.topo > pilha2.topo) 
		{
			pilha2.push(container);
			idContainers2[posicao2] = identificacao;
			posicao2++;
		} 
		else 
		{
			pilha1.push(container);
			idContainers1[posicao1] = identificacao;
			posicao1++;
		}
	}
	public void retiraContainerDaPilha(TipoPilhaConteiner pilha1, TipoPilhaConteiner pilha2) {
		System.out.println("Informe o código de identificação do container: ");
		int identificacao = ler.nextInt();

		boolean containerRemovidoPilha1 = removerContainerPorId(pilha1, idContainers1, identificacao);
		if (containerRemovidoPilha1) {
			posicao1--;
			return;
		}

		boolean containerRemovidoPilha2 = removerContainerPorId(pilha2, idContainers2, identificacao);
		if (containerRemovidoPilha2) {
			posicao2--;
			return;
		}
	}	
	public void apresentacaoContainers(TipoPilhaConteiner pilha1, TipoPilhaConteiner pilha2) {
		System.out.println("************* Ocupação das pilhas de conteineres ****************** \n");

		System.out.println("        PILHA 1");

		System.out.println("topo-> " + pilha1.topo + "]:");
		for (int i = pilha1.topo - 1; i >= 0; i--)
			if (idContainers1[i] != 0)
				System.out.println("       " + i + "]: " + pilha1.dados[i]);

		System.out.println("        PILHA 2");

		System.out.println("topo-> " + pilha2.topo + "]:");
		for (int i = pilha2.topo - 1; i >= 0; i--)
			if (idContainers2[i] != 0)
				System.out.println("       " + i + "]: " + pilha2.dados[i]);
	}
	public void apresentacaoPilhas() {
		System.out.println("********** Planilha de conteiners (pilha 1) **************");
		for (int idContainer : idContainers1) 
			if (idContainer != 0)
				System.out.println(idContainer);
	

		System.out.println("\n\n ********** Planilha de conteiners (pilha 2) **************");
		for (int idContainer : idContainers2) 
			if (idContainer != 0)
				System.out.println(idContainer);
		

	}
	public void movimentacoes()
	{
		System.out.println("Número de movimentações: " + movimentacaoGlobal);
	}
	
	
	//Métodos auxiliares!
	public void removerIdDoContainer(int id, int[] idContainers) {
		boolean movimentar;

		for (int i = 0; i < idContainers.length; i++) {
			int idContainer = idContainers[i];

			if (idContainer == id)
				movimentar = true;
			else 
				movimentar = false;

			if (movimentar) 
				idContainers[i] = (i + 1) < idContainers.length ? idContainers[i + 1] : 0;
		}
	}
	public int buscarIdContainer(int id, int[] idContainers) {
		if (idContainers.length == 0) 
			return -1;

		for (int idContainer : idContainers) 
			if (id == idContainer)
				return idContainer;

		return -1;
	}
	public boolean removerContainerPorId(TipoPilhaConteiner pilha, int[] idContainers, int identificacao) {
		int idContainerPilha = buscarIdContainer(identificacao, idContainers);

		if (idContainerPilha == -1) {
			return false;
		}

		removerIdDoContainer(identificacao, idContainers);

		TipoPilhaConteiner pilhaAux = new TipoPilhaConteiner();
		pilhaAux.init();

		boolean containerRemovido = false;

		do {
			Container container = pilha.pop();
			container.contMove = container.contMove + 1;
			movimentacaoGlobal++;

			System.out.println("Movimentado o container " + container.id);

			if (container.id == identificacao) {
				System.out.println("Conteiner " + container.id + " saindo para seu destino final");
				containerRemovido = true;
			} else {
				pilhaAux.push(container);
			}

		} while (!containerRemovido);

		while (!pilhaAux.isEmpty()) {
			Container container = pilhaAux.pop();
			container.contMove = container.contMove + 1;
			movimentacaoGlobal++;
			pilha.push(container);
		}

		return true;
	}
	
}

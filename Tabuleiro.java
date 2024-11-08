import java.io.IOException;
import java.util.LinkedList;

public class Tabuleiro {
    private Posicao[] posicoeDoTabuleiro;
	private RecuperaDadosDoTXT recupera = new RecuperaDadosDoTXT();
	private LinkedList<SorteOuReves> baralho;

	private static final String ARQUIVO_POSICOES_ESPECIAIS = "./Arquivos/posicoesEspeciais.txt";
	private static final String ARQUIVO_COMPANHIAS = "./Arquivos/companhias.txt";
	private static final String ARQUIVO_PRISAO = "./Arquivos/prisao.txt";
	private static final String ARQUIVO_TERRENOS = "./Arquivos/terrenos.txt";
	private static final String ARQUIVO_POSICOES_DE_SORTE_OU_REVES = "./Arquivos/posicaoDeSorteOuReves.txt";
	private static final String ARQUIVO_SORTE_OU_REVES = "./Arquivos/cartasDeSorteOuReves.txt";

    public Tabuleiro() {
		this.posicoeDoTabuleiro = new Posicao[41];
		recuperaCompanhias();
		recuperaPosicoesEspeciais();
		recuperaPrisao();
		recuperaTerrenos();
		recuperaPosicoesDeSorteOuReves();
		try {
			this.baralho = recupera.recuperaCartas(ARQUIVO_SORTE_OU_REVES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Posicao getPosicoeDoTabuleiro(int indice) {
		return this.posicoeDoTabuleiro[indice];
	}

    public void recuperaCompanhias() {

		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_COMPANHIAS)) {

				String[] linha = s.split(",");

				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				int preco = Integer.parseInt(linha[2]);
				int multiplicador = Integer.parseInt(linha[3]);

				Companhia c = new Companhia(posicao, nome, preco, multiplicador);

				this.posicoeDoTabuleiro[posicao] = c;

			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o arquivo TXT de companhia");
		}
	}

    public void recuperaPosicoesEspeciais() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_POSICOES_ESPECIAIS)) {

				String[] linha = s.split(",");
				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				if (nome.equals("Lucros e Dividendos")) {
					Posicao p = new LucroEDividendo(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Parada Livre")) {
					Posicao p = new ParadaLivre(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Imposto de Renda")) {
					Posicao p = new ImpostoDeRenda(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				} else if (nome.equals("Ponto de partida")) {
					Posicao p = new PontoDePartida(posicao);
					this.posicoeDoTabuleiro[posicao] = p;
				}

			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o arquivo TXT posições especiais");
		}

	}

    public void recuperaPrisao() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_PRISAO)) {

				String[] linha = s.split(",");
				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				Prisao p = new Prisao(posicao, nome);
				this.posicoeDoTabuleiro[posicao] = p;

			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o arquivo TXT de prisão");
		}

	}

    public void recuperaTerrenos() {

		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_TERRENOS)) {

				String[] linha = s.split(",");

				int posicao = Integer.parseInt(linha[0]);
				String nome = linha[1];
				int preco = Integer.parseInt(linha[2]);
				int aluguel = Integer.parseInt(linha[3]);
				int aluguelComUmaCasa = Integer.parseInt(linha[4]);
				int aluguelComDuasCasas = Integer.parseInt(linha[5]);
				int aluguelComTresCasas = Integer.parseInt(linha[6]);
				int aluguelComQuatroCasas = Integer.parseInt(linha[7]);
				int aluguelComHotel = Integer.parseInt(linha[8]);
				int dono = Integer.parseInt(linha[9]);
				String cor = linha[10];

				Terreno t = new Terreno(posicao, nome, preco, aluguel, aluguelComUmaCasa, aluguelComDuasCasas,
						aluguelComTresCasas, aluguelComQuatroCasas, aluguelComHotel, dono, cor);

				this.posicoeDoTabuleiro[posicao] = t;

			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o arquivo TXT de terrenos");
		}

	}

    public void recuperaPosicoesDeSorteOuReves() {
		try {
			for (String s : recupera.recuperaTextoDeArquivo(ARQUIVO_POSICOES_DE_SORTE_OU_REVES)) {

				int posicao = Integer.parseInt(s);
				PosicaoSorteOuReves r = new PosicaoSorteOuReves(posicao);
				this.posicoeDoTabuleiro[posicao] = r;

			}
		} catch (IOException e) {
			System.out.println("Não foi possível recuperar o arquivo TXT de posições de sorte ou revés");
		}

	}

    public SorteOuReves getSorteOuReves() {
		SorteOuReves carta = this.baralho.pollFirst();
		this.baralho.add(carta);
		return carta;
	}


}

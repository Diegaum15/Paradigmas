public class Jogo {

	protected GerenciaJogo jogo;
	private int idJogador = 1;
	private int numeroDeJogadores;
	private boolean inicioDaPartida = true;
	private String[] listaDeCoresDisponiveis = { "preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja", "rosa" };

	public Jogo()
	{
		this.jogo = GerenciaJogo.getInstancia();
	}

	public void inciarJogo()
	{
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario comecou! Sobreviva ao capitalismo");
		partida();
	}

    // Atributos
    // Construtores
    // Metodos get set
    // Outros metodos 
}

import java.util.LinkedList;
import java.util.Scanner;

public class GerenciaJogo{

	protected static final Scanner in = new Scanner(System.in);
	protected LinkedList<Jogador> listaJogadores;
	protected Dado dado = new Dado();
	protected Tabuleiro tabuleiro = new Tabuleiro();
	private JogoFabrica fabrica;
	private int[] ultimosDados;
	private static GerenciaJogo instacia = null;

	public static GerenciaJogo getInstancia() {
		if (instancia == null) {
			instancia = new GerenciaJogoJogo();
		}
		return instancia;
	}

	public GerenciaJogo()
	{
        listaJogadores = new LinkedList<Jogador>();
        ultimosDados = new int[2];        
	}

	public String input()
	{
		return in.nextline();
	}

	public int inputInt() throws NumberFormatException {
		String textorecebido = in.nextLine();
		String outraString = textorecebido.replaceAll("\\s+", "");
		if(outraString.matches("\\D")) {
			throw new NumberFormatException("");
		}
		return Integer.parseInt(outraString);
	}

	public void addJogador(Jogador e) {
		this.listaJogadores.add(e);
	}

	public void removeJogador() {
		this.listaJogadores.remove(this.JogadorAtual());
	}

	public void pollJogador() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

    public Dado getDado()
    {
        return this.dado;
    }

	public void reset() {
		instance = null;
	}

	public boolean verificarSeTaNaPrisao(Jogador j) {
		return this.tabuleiro.getPosicoeDoTabuleiro(j.getPosicao()).getTipo().equals("Prisão");
	}

	public void verificaSeExisteJogadorComEstaCor(String cor) throws ExisteJogadorComEstaCorException {
		for (Jogador j : this.listaJogadores) {
			if (j.getCor().equals(cor)) {
				throw new ExisteJogadorComEstaCorException(
						"Já existe um jogador utilizando esta cor. Tente novamente!");
			}
		}
	}

	public boolean verificaSeAhCorEhValida(String cor) throws CorValidaException {
		if (cor.equalsIgnoreCase("preto") || cor.equalsIgnoreCase("branco") || cor.equalsIgnoreCase("vermelho")
				|| cor.equals("verde") || cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo")
				|| cor.equalsIgnoreCase("laranja") || cor.equals("rosa")) {
			return true;
		}
		throw new CorValidaException("Esta cor não é válida. Tente novamente uma cor disponível!");
	}

	public Jogador JogadorAtual() {
		return this.listaJogadores.getFirst();
	}

	public void chamarEvento() {
		this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).evento(this);

	}

	public void verificaNumeroJogadores(int numero) throws ValorInvalidoException {
		if ((numero > 8 || numero < 2)) {
			throw new ValorInvalidoException("Número de jogadores inválidos!\n");
		}
	}

	public void passarAVez() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	public boolean simOuNao(String msg) throws ValorInvalidoException {
		System.out.print(msg + "\nSim/Não");
		String escolha = this.input();
		if (escolha.matches("[\\s]*[Ss]+[Ii]*[Mm]*[\\s]*")) {
			return true;
		} else if (!(escolha.matches("[\\s]*[Nn]+[ÃãAa]*[Oo]*[\\s]*"))) {
			throw new ValorInvalidoException("Opção não permitida");
		}
		return false;
	}

	public SorteOuReves getCarta() {
		return this.tabuleiro.getSorteOuReves();
	}

	public int getNumeroDeJogadores() {
		return this.listaJogadores.size();
	}

	public Posicao getPosicaoAtual() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao());
	}

	public void setPrisao() {
		this.fabrica = new JogoFactoryPrisao();
	}

	public void setVender() {
		this.fabrica = new JogoFactoryVender();
	}
	
	
	public JogoFactory getFabrica() {
		return this.fabrica;
	}

	public void setConstruir() {
		this.fabrica = new JogoFactoryConstruir();
	}
	
	public void setFabrica() {
		this.fabrica = new JogoFactory();
	}

	public int[] getUltimosDados() {
		return ultimosDados;
	}

	public void setUltimosDados(int[] ultimosDados) {
		this.ultimosDados = ultimosDados;
	}

	public boolean podeConstruir() {
		Construtora c = new Construtora(this.JogadorAtual());
		return c.podeConstruir();
		
	}
	
	public boolean podeVender() {
		Construtora c = new Construtora(this.JogadorAtual());
		return c.podeVender();
		
	}

	public LinkedList<Jogador> getJogadores() {
		// TODO Auto-generated method stub
		return this.listaJogadores;
	}	
}
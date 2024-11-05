
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

    public Dado getDado()
    {
        return this.dado;
    }

    public SorteOuReves getCarta()
    {
        return this.tabuleiro.getSorteOuReves()
    }

    public int getNumerodeJogadores()
    {
        return this.listaJogadores.size();
    }

    public Posicao getPosicaoAtual() 
    {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao());
	}

    public void setPrisao() {
		this.fabrica = new JogoFabricaPrisao();
	}

	public void setVender() {
		this.fabrica = new JogoFabricaVender();
	}
	
	
	public JogoFabrica getFabrica() {
		return this.fabrica;
	}

	public void setConstruir() {
		this.fabrica = new JogoFabricaConstruir();
	}
	
	public void setFabrica() {
		this.fabrica = new JogoFabrica();
	}

	public int[] getUltimosDados() {
		return ultimosDados;
	}

	public void setUltimosDados(int[] ultimosDados) {
		this.ultimosDados = ultimosDados;
	}
}
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int posicaoAtual;
    private Conta conta;
    private Peao peao;
    private List<Titulo> titulos;
    private boolean carta; 
    
    public Jogador(String nome, Peao peao, int saldoInicial){
        this.nome = nome;
        this.peao = new Peao();
        this.saldo = saldoInicial;
        this.titulos = new ArrayList<>();
        this.conta = new Conta();
        this.carta = false;
        this.posicaoAtual = 0;
    }

    public int lancaDado() {
        return Dado.lancaDado();
    }
    
    public String getNome() {
        return nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public Peao getPeao() {
        return peao;
    }

    public List<CartaTerreno> gettitulos() {
        return titulos;
    }

    public void receber(int valor) {
		try {
			this.conta.deposita(valor);
		} catch (ValorInvalidoException e) {
		}
	}

    public void pagar(Jogador jogador, int valor) {
		try {
			this.conta.debita(valor);
			jogador.conta.deposita(valor);
		} catch (ValorInvalidoException e) {

		} catch (LimiteExcedidoException e) {
			if (this.titulos.size() == 0) {
				System.out.println("Falencia");
			} else {
				this.titulos.getLast().venderAoBanco(this);
				pagar(jogador, valor);
			}
		}
	}

    public boolean pagar(int valor) {
		try {
			this.conta.debita(valor);
			return true;
		} catch (ValorInvalidoException e) {
			return false;
		} catch (LimiteExcedidoException e) {
			if (this.titulos.size() == 0) {
				System.out.println("Falência!");
				GerenciaJogo.getInstance().removeJogador();
				return false;
			} else {
				this.titulos.getLast().venderAoBanco(this);
				pagar(valor);
			}
		}return false;
	}

	public void comprarTitulo(int valor, TituloStrategy t) {
		try {
			this.conta.debita(valor);
			System.out.println("Compra efetuada com sucesso!");
		} catch (ValorInvalidoException e) {
			System.err.println(e.getMessage());
		} catch (LimiteExcedidoException e) {
			System.err.println(e.getMessage() + ", saldo R$ " + this.conta.getSaldo());
		}
		this.titulos.add(t);
	}

	// JOGADOR USA DADO, PORTANTO, DADO É UM PARAMETRO DO METODO JOGADA
	public void jogada(int dado1, int dado2, GerenciaJogo jogo) {
		avancarCasas(dado1, dado2);
		System.out.println(
				this.toString() + "tirou " + dado1 + "," + dado2 + " e o peão avançou " + jogo.getPosicaoAtual());
	}

	public void avancarCasas(int dado1, int dado2) {
		this.posicao += dado1 + dado2;
		if (this.posicao > 39) {
			this.posicao -= 39;
		}
	}

	public void removeTitulo(TituloStrategy tituloFactory) {
		for (int k = 0; k < this.titulos.size(); k++) {
			if (titulos.get(k).equals(tituloFactory)) {
				System.out.println(titulos.get(k) + " foi vendido.");
				titulos.remove(k);
			}
		}
	}

	public boolean temCarta() {
		if (this.carta == true) {
			return true;
		}
		return false;
	}

	public void removeCarta() {
		this.carta = false;
	}

	public void addCarta() {
		this.carta = true;
	}

	public void vaiParaPrisao() {
		this.posicao = 30;
	}

	public void mostrarTerrenos() {
		String texto = "";
		int cont = 1;
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno() ){
				Terreno t = ((Terreno) e);
				texto = Integer.toString(cont) +" - "+ e.getNome()+" tem "+ t.getNumeroDeCasas()+" casa(s) construídas, casa custa $ "+ t.getValorDaConstrucao();
				cont += 1;
				System.out.println(texto);
			}
		}  
	}
	
	public int getNumeroDeTerrenos() {
		int cont = 0;
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno() ){
				cont += 1;
			}
		}  return cont;
	}
	
	public Terreno escolheTerreno(int n) throws NaoTemTerrenosException {
		ArrayList<Terreno> terrenos = new ArrayList<Terreno>();
		for(TituloStrategy e: this.titulos) {
			if(e.hasTerreno()){
				terrenos.add((Terreno) e);
			}
		} if(terrenos.size() > 0) {
			return terrenos.get(n-1);
		} throw new NaoTemTerrenosException("Você não tem Terrenos.");
	}
    
}

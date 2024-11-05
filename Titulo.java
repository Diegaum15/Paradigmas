public abstract class Titulo{
    protected Jogador dono;
	protected String nomeDoTitulo;
	protected int posicao;
	protected int precoDaPropriedade;

    public void evento(JogoFacade jogo) {
		if (this.dono == null) {
			System.out.println("O titulo de propriedade " + this.nomeDoTitulo + " está disponivel por $"
					+ this.precoDaPropriedade);
			System.out.println(jogo.JogadorAtual().getNome() + " possui $" + jogo.JogadorAtual().getSaldo());
			boolean escolha;
			try {
				escolha = jogo.simOuNao(("Deseja comprar " + this.nomeDoTitulo + "?"));
				if (escolha) {
					jogo.JogadorAtual().comprarTitulo(this.precoDaPropriedade, this);
					this.dono = jogo.JogadorAtual();
				}
			} catch (ValorInvalidoException e) {
				System.err.print(e.getMessage() + "\n");
				evento(jogo);

			}

		} else {
			if (!this.dono.equals(jogo.JogadorAtual())) {
				factoryMethod(jogo);
			}
		}
	}

    public abstract void factoryMethod(JogoFacade jogo);

    public abstract String getTipo();

	public abstract String mostrarTitulo();

	public void venderAoBanco(Jogador jogador) {
		this.dono = null;
		jogador.receber(this.precoDaPropriedade);
		jogador.removeTitulo(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((nomeDoTitulo == null) ? 0 : nomeDoTitulo.hashCode());
		result = prime * result + posicao;
		result = prime * result + precoDaPropriedade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TituloStrategy other = (TituloStrategy) obj;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (nomeDoTitulo == null) {
			if (other.nomeDoTitulo != null)
				return false;
		} else if (!nomeDoTitulo.equals(other.nomeDoTitulo))
			return false;
		if (posicao != other.posicao)
			return false;
		if (precoDaPropriedade != other.precoDaPropriedade)
			return false;
		return true;
	}
	
	public abstract boolean hasTerreno();
	public abstract String toString();
	public abstract boolean hasCor();
	public String getNome() {
		return this.nomeDoTitulo;
	}
}
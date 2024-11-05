public class LucroEDividendo implements Posicao {
    private int posicao;

	
	public LucroEDividendo(int posicao) {
		this.posicao = posicao;
	}

	
	@Override
	public void evento(GerenciaJogo jogo) {
		System.out.println("Você ganhou 200");
		jogo.JogadorAtual().receber(200);
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String getTipo() {
		return "Lucro e dividendo";
	}

	public String toString() {
		return this.posicao + " - Lucros ou Dividendos";
	}

}
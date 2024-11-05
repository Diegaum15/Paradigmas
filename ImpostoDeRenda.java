public class ImpostoDeRenda implements Posicao {
    private int posicao;

	public ImpostoDeRenda(int posicao) {
		this.posicao = posicao;
	}

	@Override
	public void evento(GerenciaJogo jogo) {
		System.out.println("Você pagou 200");
		jogo.JogadorAtual().pagar(200);
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String getTipo() {
		return "Imposto de renda";
	}

	public String toString() {
		return this.posicao + " - Imposto de Renda";
	}
}
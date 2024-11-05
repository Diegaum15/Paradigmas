public class PosicaoSorteOuReves implements Posicao {

	private int posicaoNoTabuleiro;

	public PosicaoSorteOuReves(int posicao) {
		this.posicaoNoTabuleiro = posicao;
	}


	@Override
	public void evento(JogoFacade jogo) {
		jogo.getCarta().acao(jogo.JogadorAtual());
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicaoNoTabuleiro;
	}

	public String toString() {
		return this.posicaoNoTabuleiro + " - Sorte ou Reves";
	}

	@Override
	public String getTipo() {
		return "Sorte ou reves";
	}

}
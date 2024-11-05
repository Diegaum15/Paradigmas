public class PontoDePartida implements Posicao {

	private int posicao;

	
	public PontoDePartida(int posicao) {
		this.posicao = posicao;
	}

	
	@Override
	public void evento(GerenciaJogo jogo) {
		System.out.println("Nada aconteceu" + jogo.JogadorAtual().getNome());
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	public String toString() {
		return this.posicao + " - Ponto de partida";
	}

	@Override
	public String getTipo() {
		return "Ponto de partida ";
	}

}
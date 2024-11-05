public class Prisao implements Posicao {

	private int posicao;
	private String nome;

    public Prisao(int posicao, String nome) {
		this.nome = nome;
		this.posicao = posicao;
	}

	
	@Override
	public void evento(GerenciaJogo jogo) {
		if (this.posicao == 30) {
			jogo.JogadorAtual().vaiParaPrisao();
		}
		System.out.println("Passou a vez");

	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.posicao + " - " + this.nome;
	}

	@Override
	public String getTipo() {
		return "Prisão";
	}
}
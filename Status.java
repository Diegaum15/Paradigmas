public class Status implements Opcao {

	@Override
	public boolean fazerOP() {
		GerenciaJogo jogo = GerenciaJogo.getInstance();
		System.out.println("O status de " + jogo.JogadorAtual().getNome() + " - " + jogo.JogadorAtual().getCor()
				+ " é o seguinte:");
		System.out.println("Situado na posição " + jogo.getPosicaoAtual());
		System.out.println("Possui $" + jogo.JogadorAtual().getSaldo());
		System.out.println("Titulos:");
		if (jogo.JogadorAtual().getTitulos().size() == 0) {
			System.out.println("O jogador " + jogo.JogadorAtual().getNome() + " não possui títulos.");
		} else {
			for (TituloStrategy c : jogo.JogadorAtual().getTitulos()) {
				System.out.println(c.mostrarTitulo());
			}
		}
		return false;
	}

}
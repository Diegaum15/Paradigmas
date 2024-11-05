public class Sair implements Opcao {
	
	@Override
	public boolean fazerOP() {
		GerenciaJogo jogo = GerenciaJogo.getInstance();
		if (jogo.getNumeroDeJogadores() > 2) {
			jogo.removeJogador();
		} else {
			jogo.removeJogador();
			System.out.println(jogo.JogadorAtual() + " é o vencedor!");
			System.exit(0);
		}
		return false;
	}

}
public class Pagar implements Opcao {
	
	@Override
	public boolean fazerOP() {
		GerenciaJogo jogo = GerenciaJogo.getInstance();		
		jogo.JogadorAtual().pagar(50);
		int novoDado = jogo.JogadorAtual().lancaDado();
		int novoDado2 = jogo.JogadorAtual().lancaDado();
		jogo.JogadorAtual().jogada(novoDado, novoDado2, jogo);
		jogo.getPosicaoAtual().evento(jogo);
		return true;
	}

}
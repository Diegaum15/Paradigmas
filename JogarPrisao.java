public class JogarPrisao extends Jogar{

    public void somaDados()
    {
        GerenciaJogo jogo = GerenciaJogo.getInstance();
		if (this.dado1 == this.dado2) {
			System.out.println("Tirou dados iguais!");
			jogo.setFabrica();
			int novoDado = jogo.JogadorAtual().lancaDado();
			int novoDado2 = jogo.JogadorAtual().lancaDado();
			jogo.JogadorAtual().jogada(novoDado, novoDado2, jogo);
			jogo.getPosicaoAtual().evento(jogo);
		} else {
			System.out.print("Dados não são iguais!");
		}
    }
}
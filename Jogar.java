public class Jogar implements Opcao{
    protected Dado dado;

    @Override
	public boolean fazerOP() 
    {
		GerenciaJogo jogo = GerenciaJogo.getInstance();
		this.dado1 = jogo.JogadorAtual().lancaDado();
		this.dado2 = jogo.JogadorAtual().lancaDado();

		int[] array = new int[2];
		array[0] = dado1;
		array[1] = dado2;
		jogo.setUltimosDados(array);

		sumDados(jogo);
		return true;

	}

    public void sumDados(GerenciaJogo jogo) {
		jogo.JogadorAtual().jogada(this.dado1, this.dado2, jogo);
		jogo.chamarEvento();

	}

}
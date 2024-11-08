public class JogoFabrica{
    protected Opcaio op;
    
	public boolean escolheOpcao(String opcao, GerenciaJogo jogo) {
		opcao = opcao.replaceAll("\\s+", "").toLowerCase();
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Você realmente quer sair? ");
				if (escolha) {
					setOpcaoSair();
					return true;
				}
				return false;

			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
			}
			break;
		default:
			setOpcaoErro();
			return false;
		}
		return true;
	}

	public boolean executarOpcao(GerenciaJogo jogo) {
		return this.op.fazerOP();
	}

	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	public void setOpcaoStatus() {
		this.op = new Status();
	}

	public void setOpcaoSair() {
		this.op = new Sair();
	}

	protected void setOpcaoErro() {
		this.op = new Erro();
	}

}
public class JogoFabricaConstruir extends JogoFabrica{
    
    public boolean escolheOpcao(String opcao, GerenciaJogo jogo) {
		opcao = opcao.replaceAll("\\s+", "").toLowerCase();
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "vender":
			setOpcaoVender();
			break;
		case "construir":
			setOpcaoConstruir();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Você realmente quer sair");
				if (escolha) {
					setOpcaoSair();
				}
			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
				return false;
			}
			break;
		default:
			setOpcaoErro();
			return false;
		}
		return true;
	}

	private void setOpcaoVender() {
		this.op = new Vender();
		
	}

	private void setOpcaoConstruir() {
		this.op = new ConstruirOP();
	}

	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}

}
public class ConstruirOP extends Carta{
    
    @Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		int entrada = -1;
		while(entrada != 0) {
			System.out.println(jogo.JogadorAtual().getNome()+" possui "+jogo.JogadorAtual().getSaldo());
			System.out.println("Escolha onde quer construir:");
			jogo.JogadorAtual().mostrarTerrenos();
			System.out.println("Digite o número da propriedade (0 para sair):");
			try {
				entrada = jogo.inputInt();
			} catch (NumberFormatException e1) {
				System.err.println(e1.getMessage());
			}
			try {
				if(entrada>= 1 && entrada <= jogo.JogadorAtual().getNumeroDeTerrenos()) {
					jogo.JogadorAtual().escolheTerreno(entrada).construir();
				}else if(entrada != 0){
					System.err.print("Opção inválida!\n");
				} 
			}catch (NaoTemTerrenosException e) {
				System.err.print(e.getMessage()+"\n");
			}
			
		}
		return true;
	}

}
public class VaParaPrisao extends SorteOuReves {
    public VaParaPrisao(String descricao, String valor) {
        super(descricao, valor);
    }

    @Override
    public void acao(Jogador jogador) 
    {
        System.out.println(this.descricao);
        jogador.vaiParaPrisao();
    }
}
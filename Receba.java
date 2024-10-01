public class Receba extends SorteOuReves {
    public Receba(String descricao, String valor) {
        super(descricao, valor);
    }

    @Override
    public void acao(Jogador jogador) 
    {
        System.out.println(this.descricao + "\n Voce recebeu: " + this.valor + "do banco");
        jogador.receber(this.valor);
    }
}
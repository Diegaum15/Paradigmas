public class Pague extends SorteOuReves {
    public Pague(String descricao, int valor) {
        super(descricao, valor);
    }

    @Override
    public void aplicarEfeito(Jogador jogador) {
        jogador.pagar(valor);
        System.out.println(this.descricao +"\n" +"Pagou " + valor + this.valor);
    }
}
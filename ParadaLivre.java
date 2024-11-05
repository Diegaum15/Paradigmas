public class ParadaLivre implements Posicao {
    public class ParadaLivre implements Posicao {

        private int posicao;
    
        public ParadaLivre(int posicao) {
            this.posicao = posicao;
        }
    
        @Override
        public void evento(GerenciaJogo jogo) {
            System.out.println("Nada Aconteceu.");
        }
    
        @Override
        public int getNumeroDePosicao() {
            return this.posicao;
        }
    
        @Override
        public String toString() {
            return this.posicao + "- Parada Livre";
        }
    
        @Override
        public String getTipo() {
            return "Parada Livre";
        }
    
    }
}
public class Dados {
    private int dado1;
    private int dado2;
    
    public int lancarDados() {
        this.dado1 = (int) (Math.random() * 6) + 1;
        this.dado2 = (int) (Math.random() * 6) + 1;
        soma = dado1 + dado2;
        return soma;
    }
    
    public int getSomaDados() {
        return dado1 + dado2;
    }
    
    public boolean isDupla() {
        return dado1 == dado2;
    }
}

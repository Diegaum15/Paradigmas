public class Dados {
    private int dado1;
    private int dado2;
    
    public void lancarDados() {
        dado1 = (int) (Math.random() * 6) + 1;
        dado2 = (int) (Math.random() * 6) + 1;
    }
    
    public int getSomaDados() {
        return dado1 + dado2;
    }
    
    public boolean isDupla() {
        return dado1 == dado2;
    }
}

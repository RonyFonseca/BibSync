package strategy;

public class BibStrategy {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void criarBib(){
        strategy.criarBib();
    }
}

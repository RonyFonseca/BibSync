package strategy;

import factory.Factory;
import model.Bib;

import java.util.ArrayList;
import java.util.List;

public class FilterStrategy {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void filtrar(List<Bib> bibs) {
        if(strategy == null){
            System.out.println("Nem um parâmetro de pesquisa foi atribuido !");
        }
        strategy.filtrar(bibs);
    }
}

package strategy;

import factory.Factory;
import factory.FactoryMDPI;

public class BibMDPI implements Strategy{
    @Override
    public Factory criarBib() {
        return new FactoryMDPI();
    }
}

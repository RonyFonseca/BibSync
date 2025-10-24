package strategy;

import factory.Factory;
import factory.FactoryIEEE;

public class BibIEEE implements Strategy{
    @Override
    public Factory criarBib() {
        return new FactoryIEEE();
    }
}

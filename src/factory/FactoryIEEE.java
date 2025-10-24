package factory;

import model.Bib;
import servirces.BibServices;

import java.util.List;

public class FactoryIEEE implements Factory {
    BibServices bibservices = new BibServices("IEEE");

    @Override
    public List<model.Bib> lerArquivo() {
        System.out.println("Lendo arquivo da IEEE");
        List<model.Bib> artigos = bibservices.tratarBib();
        return artigos;
    }

    @Override
    public String getFonte() {
        return "IEEE";
    }
}

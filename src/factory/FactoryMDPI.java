package factory;

import model.Bib;
import servirces.BibServices;

import java.util.ArrayList;
import java.util.List;

public class FactoryMDPI implements Factory {
    BibServices bibservices = new BibServices("mdpi");

    @Override
    public List<model.Bib> lerArquivo() {
        System.out.println("Lendo arquivo MDPI");
        List<model.Bib> artigos = bibservices.tratarBib();
        return artigos;
    }

    @Override
    public String getFonte() {
        return "MDPI";
    }
}

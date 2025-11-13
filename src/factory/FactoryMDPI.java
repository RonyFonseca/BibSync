package factory;

import model.Bib;
import servirces.BibServices;

import java.util.ArrayList;
import java.util.List;

public class FactoryMDPI implements Factory {
    BibServices bibservices = new BibServices("mdpi");
    public String nome;

    public FactoryMDPI(String nome){
        this.nome = nome;
    }

    public FactoryMDPI(){}

    @Override
    public List<Factory> lerArquivo() {
        System.out.println("Lendo arquivo MDPI");
        List<Factory> artigos = bibservices.importarBibs();
        return artigos;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getFonte() {
        return "MDPI";
    }
}

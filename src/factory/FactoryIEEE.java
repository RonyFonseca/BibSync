package factory;

import model.Bib;
import servirces.BibServices;

import java.util.List;

public class FactoryIEEE implements Factory {
    BibServices bibservices = new BibServices();
    public String nome;

    public FactoryIEEE(String nome){
        this.nome = nome;
    }

    public FactoryIEEE(){}

    @Override
    public List<Factory> lerArquivo() {
        System.out.println(nome);
        List<Factory> artigos = bibservices.importarBibs();
        return artigos;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getFonte() {
        return "IEEE";
    }
}

package strategy;

import factory.Factory;
import factory.FactoryMDPI;
import model.Bib;

import java.util.ArrayList;
import java.util.List;

public class FilterAutor implements Strategy{
    private String autor;

    public FilterAutor(String autor){
        this.autor = autor;
    }

    @Override
    public void filtrar(List<Bib> bibs) {
        for(Bib b : bibs){
            if(b.getAutor().toLowerCase().contains(autor.toLowerCase())){
                System.out.println();
                System.out.println();
                System.out.println("==========================[Artigo]=========================");
                System.out.println(b.getTitulo());
                System.out.println();
                System.out.println("    =Informações=");
                System.out.println("    Autor:" + b.getAutor());
                System.out.println("    Ano:" + b.getAno());
                System.out.println("    =============");
                System.out.println();
                System.out.println("=Resumo=");
                System.out.println(b.getResumo());
                System.out.println("===========================================================");
                System.out.println();
                System.out.println();
            }
        }
    }
}

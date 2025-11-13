package strategy;

import factory.Factory;
import model.Bib;

import java.util.ArrayList;
import java.util.List;

public class FilterTitulo implements Strategy{
    private String titulo;

    public FilterTitulo(String titulo){
        this.titulo = titulo;
    }

    @Override
    public void filtrar(List<Bib> bibs) {
        for(Bib b: bibs){
            if(b.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
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

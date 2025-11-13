package strategy;

import factory.Factory;
import factory.FactoryIEEE;
import model.Bib;

import java.util.ArrayList;
import java.util.List;

public class FilterAno implements Strategy{
    private String ano;

    public  FilterAno(String ano){
        this.ano = ano;
    }
    @Override
    public void filtrar(List<Bib> bibs) {
        for(Bib b : bibs){
            if(b.getAno().contains(ano)){
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

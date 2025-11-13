package strategy;

import model.Bib;

import java.util.List;

public class FilterResumo implements Strategy {
    private String resumo;

    public FilterResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public void filtrar(List<Bib> bibs) {
        for(Bib b : bibs){
            if(b.getResumo().toLowerCase().contains(resumo.toLowerCase())){
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

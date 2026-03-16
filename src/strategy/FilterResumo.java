package strategy;

import model.Bib;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class FilterResumo implements Strategy {
    private String resumo;

    public FilterResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public void filtrar(List<Bib> bibs) {
        for(Bib b : bibs){
            String text = resumo.toLowerCase().replace("[","").replace("]","");
            String[] items = text.split(",");
            if(items.length>1){
                int acertos = 0;
                for(String s:items){
                    if(b.getResumo().toLowerCase().contains(s)){
                        acertos++;
                    }
                }

                if(acertos == items.length){
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
            }else {
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
}

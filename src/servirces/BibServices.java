package servirces;

import model.Bib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibServices {
    private final String path = "C:\\Users\\Rony\\Desktop\\BibSync\\data\\bibs";
    private String tipo;

    public BibServices(String tipo){
        switch (tipo.toLowerCase()){
            case "ieee":
                this.tipo = "IEEE";
                break;
            case "mdpi":
                this.tipo = "mdpi";
                break;
        }
    }

    public BibServices(){}

    public void ListarBibs(){
        File pasta = new File(path);

        if(pasta.exists() && pasta.isDirectory()){
            File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

            if(arquivos != null && arquivos.length > 0){
                System.out.println("Arquivos .bib encontrados:");
                for (File arquivo : arquivos) {
                    System.out.println(arquivo.getName());
                }
            }else {
                System.out.println("Nenhum arquivo .bib encontrado");
            }
        } else {
            System.out.println("O caminho especificado não é uma pasta válida");
        }
    }

    public void identificarTipoBib(){
        File pasta = new File(path);

        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

        for (File arquivo : arquivos) {
            try {
                BufferedReader file = new BufferedReader(new FileReader(path+"\\"+arquivo.getName()));
                if(file.readLine().contains("@IN")){
                    System.out.println(arquivo.getName()+" - IEEE");
                }else {
                    System.out.println(arquivo.getName()+" - MDPI");
                }
            } catch (IOException e) {
                System.out.println("Erro ao indentificar o tipo: "+ e);;
            }
        }

    }

    public List<Bib> importarBibs(){

        int quanidadeDeLinhas = percorerLinhasBib();

        return tratarLinhasBib(quanidadeDeLinhas);

    }

    private int percorerLinhasBib(){
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo+".bib"));

            int contador =0;

            while(arquivo.readLine() != null){
                contador ++;
            }

            arquivo.close();

            return contador;

        }catch (IOException e){
            System.out.println("Erro ao percorrer as linhas "+e);
        }
        return 0;
    }

    public List<Bib> tratarLinhasBib(int quantidadeLinhas){
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo+".bib"));

            List<String> bibs = arquivo.readAllLines();

            List<Bib> artigosEncontrados = new ArrayList<>();

            String autor = "";
            String titulo= "";
            String ano= "";
            String resumo= "";
            String doi= "";
            String url= "";

            for(String b:bibs){
                if(b.toLowerCase().contains("author")){
                    autor = b;
                }else if(b.toLowerCase().contains("booktitle")){
                    titulo = b;
                }else if(b.toLowerCase().contains("year")){
                    ano = b;
                }else if(b.toLowerCase().contains("abstract")){
                    resumo = b;
                }else if(b.toLowerCase().contains("doi")){
                    doi = b;
                }else if(b.toLowerCase().contains("url")){
                    url = b;
                }

                switch (this.tipo){
                    case "IEEE":
                        if(b.contains("@IN")){
                            Bib artigo = new Bib(titulo, ano, autor, resumo, doi,url);
                            artigosEncontrados.add(artigo);
                        }
                        break;
                    case "mdpi":
                        if(b.contains("@Article")){
                            Bib artigo = new Bib(titulo, ano, autor, resumo, doi,url);
                            artigosEncontrados.add(artigo);
                        }
                        break;
                }
            }

           return artigosEncontrados;

        }catch (IOException e){
            System.out.println("Erro ao ler as linhas "+e);
        }

        return List.of();
    }
}

package servirces;

import model.Bib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public List<Bib> tratarBib(){
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo+".bib"));

            int quanidadeDeLinhas = percorerLinhasBib();

            return lerLinhasBib(quanidadeDeLinhas);

        }catch (IOException e){
            System.out.println("Erro ao tratar "+e);
        }
        return List.of();
    }

    public int percorerLinhasBib(){
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

    public List<Bib> lerLinhasBib(int quantidadeLinhas){
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

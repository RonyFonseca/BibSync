package servirces;

import model.Bib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibServices {
    private final String path = "C:\\Users\\Rony\\Desktop\\BibSync\\data\\bibs";
    private String tipo;
    private ArrayList<String> todosBibs;
    private List<String> nomesDosImportados= new ArrayList<>();

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

    public BibServices(){
        this.todosBibs = pegarNomeDosBibs();
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Rony\\Desktop\\BibSync\\data\\historico\\importados.txt"));
            this.nomesDosImportados = new ArrayList<>(arquivo.readAllLines());
            arquivo.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public ArrayList<String> listarBibs(){
        File pasta = new File(path);
        ArrayList<String> nomesBibs = new ArrayList<>();

        if(pasta.exists() && pasta.isDirectory()){
            File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

            if(arquivos != null && arquivos.length > 0){
                for (File arquivo : arquivos) {
                    nomesBibs.add(arquivo.getName());
                }
            }else {
                System.out.println("Nenhum arquivo .bib encontrado");
            }
        } else {
            System.out.println("O caminho especificado não é uma pasta válida");
        }

        return nomesBibs;
    }

    public ArrayList<String> identificarImportados(){
        File pasta = new File(path);

        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

        ArrayList<String> importados = new ArrayList<>();

        for (int i=0; i<arquivos.length; i++) {
            for(int j=0; j<this.nomesDosImportados.size(); j++){
                if(arquivos[i].getName().equals(this.nomesDosImportados.get(j))){
                    importados.add(arquivos[i].getName());
                }
            }
        }

        return importados;

    }

    public ArrayList<String> pegarNomeDosBibs(){
        File pasta = new File(path);

        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

        ArrayList<String> nomesArtigos = new ArrayList<>();

        for (File arquivo : arquivos) {
            nomesArtigos.add(arquivo.getName());
        }

        return nomesArtigos;
    }


    public List<List<Bib>> importarBibs(){
        List<List<Bib>> todosBibsMatriz = new ArrayList<>();

        try{
            BufferedWriter arquivo_historio_importados = new BufferedWriter(new FileWriter("C:\\Users\\Rony\\Desktop\\BibSync\\data\\historico\\importados.txt"));

            for(int i=0; i<todosBibs.size(); i++){
                this.tipo = todosBibs.get(i).toString();

                int quanidadeDeLinhas = percorerLinhasBib();

                List<Bib> bibs =  tratarLinhasBib(quanidadeDeLinhas);
                nomesDosImportados.add(tipo);
                todosBibsMatriz.add(bibs);
                arquivo_historio_importados.write(this.tipo);
                arquivo_historio_importados.newLine();
            }

            arquivo_historio_importados.close();
        }catch (IOException e){
            System.out.println(e);
        }

        return todosBibsMatriz;

    }

    public List<List<Bib>> importarBibs(String arquivoNome){
        List<List<Bib>> todosBibsMatriz = new ArrayList<>();

        if(this.nomesDosImportados.contains(arquivoNome)){
            System.out.println("Esse Bib já está importado !");
            return List.of();
        }

        try{
            BufferedWriter arquivo_historio_importados = new BufferedWriter(new FileWriter("C:\\Users\\Rony\\Desktop\\BibSync\\data\\historico\\importados.txt", true));

            this.tipo = arquivoNome;

            int quanidadeDeLinhas = percorerLinhasBib();

            List<Bib> bibs =  tratarLinhasBib(quanidadeDeLinhas);
            nomesDosImportados.add(tipo);
            todosBibsMatriz.add(bibs);
            arquivo_historio_importados.write(this.tipo);
            arquivo_historio_importados.newLine();

            arquivo_historio_importados.close();
        }catch (IOException e){
            System.out.println(e);
        }

        return todosBibsMatriz;

    }

    public void removerBib(String nome){
        List<String> remover = new ArrayList<>();

        try{
            BufferedWriter arquivo_historio_importados = new BufferedWriter(new FileWriter("C:\\Users\\Rony\\Desktop\\BibSync\\data\\historico\\importados.txt"));

            for(String n:this.nomesDosImportados){
                if(n.equals(nome)){
                    remover.add(n);
                }else if(nome.equals(null)) {
                    remover.add(n);
                }
            }

            this.nomesDosImportados.removeAll(remover);


            for(String n:this.nomesDosImportados){
                arquivo_historio_importados.write(n);
                arquivo_historio_importados.newLine();
            }

            arquivo_historio_importados.close();

        }catch (IOException e){
            System.out.println(e);
        }catch (NullPointerException e){
            System.out.println("Base removida com sucesso!");
            this.nomesDosImportados = new ArrayList<>();
        }
    }

    private int percorerLinhasBib(){
        try{

            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo));

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
            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo));

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

                Bib artigo = new Bib(titulo, ano, autor, resumo, doi,url);
                artigosEncontrados.add(artigo);
            }
           return artigosEncontrados;

        }catch (IOException e){
            System.out.println("Erro ao ler as linhas "+e);
        }

        return List.of();
    }
}

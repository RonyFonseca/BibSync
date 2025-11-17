package servirces;

import factory.BibFactory;
import factory.Factory;
import factory.FactoryIEEE;
import factory.FactoryMDPI;
import model.Bib;
import observer.LogMeneger;
import observer.LogObserver;
import observer.Observer;
import singleton.ImportadosURL;
import strategy.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibServices{
    private final String path = "data/bibs";
    private String tipo;
    private ArrayList<String> todosBibs;
    private List<String> nomesDosImportados= new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    LogMeneger manager = new LogMeneger();
    LogObserver observer = new LogObserver();

    public BibServices(String tipo){
        manager.adicionarObservador(observer);
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
        manager.adicionarObservador(observer);
        try {
            BufferedReader arquivo = ImportadosURL.getInstance().getArquivoLer();
            this.nomesDosImportados = new ArrayList<>();
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                this.nomesDosImportados.add(linha);
            }
            arquivo.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }


    public List<Factory> importarBibs(){
        List<Factory> bibsFactory = new ArrayList<>();

        try{
            BufferedWriter arquivo_historio_importados = ImportadosURL.getInstance().getArquivoEscrever();

            for(int i=0; i<todosBibs.size(); i++){
                this.tipo = todosBibs.get(i).toString();

                if(!nomesDosImportados.contains(tipo)){
                    nomesDosImportados.add(tipo);
                }

                String tipo = analisadorDeTipo(todosBibs.get(i).toString());
                Factory factory = BibFactory.criarBib(tipo, todosBibs.get(i).toString());

                bibsFactory.add(factory);

                arquivo_historio_importados.write(this.tipo);
                arquivo_historio_importados.newLine();
            }

            arquivo_historio_importados.close();
            manager.notificarObservadores(todosBibs.size()+" Bibs adicionados ");
        }catch (IOException e){
            System.out.println(e);
        }

        return bibsFactory;

    }

    public List<Factory> importarBibs(Factory bib){
        List<Factory> todosBibsMatriz = new ArrayList<>();

        if(this.nomesDosImportados.contains(bib.getNome())){
            System.out.println("Esse Bib já está importado !");
            return List.of();
        }

        try{
            BufferedWriter arquivo_historio_importados = ImportadosURL.getInstance().getArquivoEscrever();

            this.tipo = bib.getNome();

            nomesDosImportados.add(tipo);

            String tipoDoBib = analisadorDeTipo(bib.getNome());
            todosBibsMatriz.add(bib);
            arquivo_historio_importados.write(this.tipo);
            arquivo_historio_importados.newLine();
            arquivo_historio_importados.close();

            manager.notificarObservadores(this.tipo+ " adicionado - "+tipoDoBib);
        }catch (IOException e){
            System.out.println(e);
        }

        return todosBibsMatriz;

    }


    public String analisadorDeTipo(String arquivo){
        if(arquivo.contains("IEEE")){
            return "IEEE";
        }else{
            return "MDPI";
        }
    }

    public void removerBib(String nome){
        List<String> remover = new ArrayList<>();

        try{
            BufferedWriter arquivo_historio_importados = ImportadosURL.getInstance().getArquivoEscrever();

            for(String n:this.nomesDosImportados){//Logica de remover todos ou só um
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
            manager.notificarObservadores(remover.size()+ " Bib removido ");
        }catch (IOException e){
            System.out.println(e);
        }catch (NullPointerException e){
            System.out.println("Base removida com sucesso!");
            this.nomesDosImportados = new ArrayList<>();
            manager.notificarObservadores(" Todos Bibs Removidos ");
        }
    }

    public List<Factory> listarBibs(){
        File pasta = new File(path);
        List<Factory> nomesBibs = new ArrayList<>();

        if(pasta.exists() && pasta.isDirectory()){
            File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

            if(arquivos != null && arquivos.length > 0){
                for (File arquivo : arquivos) {
                    String tipo = analisadorDeTipo(arquivo.getName());
                    Factory factory = BibFactory.criarBib(tipo, arquivo.getName());
                    nomesBibs.add(factory);
                }
            }else {
                System.out.println("Nenhum arquivo .bib encontrado");
            }
        } else {
            System.out.println("O caminho especificado não é uma pasta válida");
        }

        return nomesBibs;
    }

    public List<Factory> identificarImportados(){
        File pasta = new File(path);

        File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".bib"));

        List<Factory> importados = new ArrayList<>();

        for (int i=0; i<arquivos.length; i++) {
            for(int j=0; j<this.nomesDosImportados.size(); j++){
                if(arquivos[i].getName().equals(this.nomesDosImportados.get(j))){
                    String tipo =analisadorDeTipo(arquivos[i].getName());
                    Factory factory = BibFactory.criarBib(tipo, arquivos[i].getName());
                    importados.add(factory);
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
        boolean IEE = false;
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(path+"\\"+tipo));

            List<String> bibs = new ArrayList<>();
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                bibs.add(linha);
            }

            List<Bib> artigosEncontrados = new ArrayList<>();

            String autor = "";
            String titulo= "";
            String ano= "";
            String resumo= "";
            String doi= "";
            String url= "";

            for(String b:bibs){

                String regex = "\\{([^}]*)\\}";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(b);

                if(matcher.find()){
                    if(b.toLowerCase().contains("author")){
                        autor = matcher.group(1);
                    }else if(b.toLowerCase().contains("booktitle") || b.toLowerCase().contains("title")){
                        if(b.toLowerCase().contains("booktitle")){
                            IEE = true;
                        }
                        titulo = matcher.group(1);
                    }else if(b.toLowerCase().contains("year")){
                        ano = matcher.group(1);
                    }else if(b.toLowerCase().contains("abstract")){
                        resumo = matcher.group(1);
                    }else if(b.toLowerCase().contains("doi")){
                        doi = matcher.group(1);
                    }else if(b.toLowerCase().contains("url")){
                        url = matcher.group(1);
                        if(IEE){
                            Bib artigo = new Bib(titulo, ano, autor, resumo, doi,url);
                            artigosEncontrados.add(artigo);
                        }
                    }
                }

                if(b.equals("}")){
                    Bib artigo = new Bib(titulo, ano, autor, resumo, doi,url);
                    artigosEncontrados.add(artigo);
                }
            }
            return artigosEncontrados;

        }catch (IOException e){
            System.out.println("Erro ao ler as linhas "+e);
        }

        return List.of();
    }

    public void procurarBib(int value, String string){
        ArrayList<Bib> artigosEncontrados = new ArrayList<>();

        for(String nome:nomesDosImportados){
            this.tipo = nome;
            int quantidadeLinhas = percorerLinhasBib();

            List<Bib> bibsTratados = tratarLinhasBib(quantidadeLinhas);
            FilterStrategy filtro = new FilterStrategy();

            switch (value){
                case 1:
                    filtro.setStrategy(new FilterTitulo(string));
                    break;
                case 2:
                    filtro.setStrategy(new FilterAutor(string));
                    break;
                case 3:
                    filtro.setStrategy(new FilterAno(string));
                    break;
                case 4:
                    filtro.setStrategy(new FilterResumo(string));
                    break;
            }
            filtro.filtrar(bibsTratados);
        }


    }
}

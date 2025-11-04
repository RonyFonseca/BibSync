package servirces;

import observer.LogMeneger;
import observer.LogObserver;
import observer.Observer;
import singleton.QuerysURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QueryServices {
    private ArrayList<String> queryBusca= new ArrayList<>();
    private BibServices bibServices = new BibServices();
    private List<Observer> observadores = new ArrayList<>();

    LogMeneger manager = new LogMeneger();
    LogObserver observer = new LogObserver();

    public  QueryServices(){
       try{
           manager.adicionarObservador(observer);
           BufferedReader arquivoLer = QuerysURL.getInstance().getArquivoLer();

           String linha;
           while((linha = arquivoLer.readLine())!=null){
               queryBusca.add(linha);
           }

           arquivoLer.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void salvarQuery(ArrayList<String> querys){

        queryBusca.add(String.valueOf(querys));
        String[] buscar = querys.toArray(new String[0]);

        pesquisarArtigoPorQuery(buscar);
        //Buscar os resumos de artigos que correspondem a query

        try {
            BufferedWriter arquivoEscrever = QuerysURL.getInstance().getArquivoEscrever();
            for(String query : queryBusca){
                arquivoEscrever.write(query);
                arquivoEscrever.newLine();
            }
            arquivoEscrever.close();
            manager.notificarObservadores( " Query adicionada ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisarArtigoPorQuery(String[] query){

        String queryTratada ="";
        if(query[0].contains("[")){
            int inicio = query[0].indexOf("[");
            int fim = query[0].indexOf("]");

            if (inicio != -1 && fim != -1 && fim > inicio) {
                queryTratada = query[0].substring(inicio + 1, fim);
            }
        }else {
            queryTratada = query[0];
        }



        bibServices.procurarBib(4, queryTratada.toLowerCase());
    }

    public ArrayList pegarQuerysSalvas (){
        return this.queryBusca;
    }

    public void removerQuery(int opc){
        List<String> remover = new ArrayList<>();
        try{
            BufferedWriter arquivo = QuerysURL.getInstance().getArquivoEscrever();

            remover.add(queryBusca.get(opc));

            this.queryBusca.removeAll(remover);

            for(String q:this.queryBusca){
                arquivo.write(q);
                arquivo.newLine();
            }

            arquivo.close();
            manager.notificarObservadores(remover.size()+ " Query removida ");
        }catch (IOException e){
            System.out.println(e);
        }
    }



}

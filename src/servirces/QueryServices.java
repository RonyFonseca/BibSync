package servirces;

import observer.LogMeneger;
import observer.LogObserver;
import observer.Observer;
import singleton.QuerysURL;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        bibServices.procurarBib(4, Arrays.toString(query));
    }

    public void mostrarHistoricoQuerys() {
        System.out.println("\n=========[ Histórico de Buscas (Querys) ]=========");
        if (queryBusca.isEmpty()) {
            System.out.println("Nenhuma query salva no histórico.");
        } else {
            for (String query : queryBusca) {
                System.out.println(query);
            }
        }
        System.out.println("===================================================\n");
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

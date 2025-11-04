package singleton;

import java.io.*;

public class QuerysURL {
    private static QuerysURL unicainstancia;
    private BufferedReader arquivoLer;
    private BufferedWriter arquivoEscrever;

    private String caminho = "C:\\Users\\Rony\\Desktop\\BibSync\\data\\historico\\querys.txt";

    private QuerysURL(){
        try{
            File file = new File(caminho);
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static QuerysURL getInstance(){
        if(unicainstancia==null){
            unicainstancia = new QuerysURL();
        }
        return unicainstancia;
    }

    public BufferedReader getArquivoLer()throws IOException{
        return new BufferedReader(new FileReader(caminho));
    }

    public BufferedWriter getArquivoEscrever()throws IOException{
        return new BufferedWriter(new FileWriter(caminho));
    }
}

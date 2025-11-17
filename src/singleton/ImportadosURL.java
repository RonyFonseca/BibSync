package singleton;

import java.io.*;

public class ImportadosURL {
    private static ImportadosURL unicainstancia;
    private BufferedReader arquivoLer;
    private BufferedWriter arquivoEscrever;

    private String caminho = "data/historico/importados.txt";

    private ImportadosURL(){
        try{
            File file = new File(caminho);
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static ImportadosURL getInstance(){
        if(unicainstancia==null){
            unicainstancia = new ImportadosURL();
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

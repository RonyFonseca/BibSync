package observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogObserver implements Observer{
    @Override
    public void atualizar(String msg) {
        try {
            BufferedWriter arquivo = new BufferedWriter(new FileWriter("C:\\Users\\ronyf\\OneDrive\\Área de Trabalho\\BibSync\\data\\logs\\logs.txt",true));
            arquivo.write("LOG# "+msg+" : "+horaAtual()+"\n");
            arquivo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String horaAtual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }
}

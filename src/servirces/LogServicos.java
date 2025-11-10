package servirces;

import java.io.*;

public class LogServicos {

    private String caminhoLog = "C:\\Users\\PROFESSOR\\IdeaProjects\\BibSync\\data\\logs\\logs.txt";
    
    public void visualizarLogs() {
        System.out.println("\n========[ Visualizar Logs ]========");
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoLog))) {
            String linha;
            boolean logsEncontrados = false;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                logsEncontrados = true;
            }
            if (!logsEncontrados) {
                System.out.println("Nenhum log encontrado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de log não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de log: " + e.getMessage());
        }
        System.out.println("=====================================\n");
    }

    public void limparLogs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoLog, false))) {
            // Abrir e fechar o FileWriter no modo não-append (false) apaga o conteúdo.
            writer.write("");
            System.out.println("\nHistórico de logs limpo com sucesso.\n");
        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo de log: " + e.getMessage());
        }
    }
}



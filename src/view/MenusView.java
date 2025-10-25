package view;

import java.util.Scanner;

public class MenusView {
    private Scanner sc;

    public MenusView(){
        this.sc = new Scanner(System.in);
    }


    public int menuPrincipal(){
        int opc = -1;

        do{
            System.out.println("========[HOME]========");
            System.out.println("[1]-Importar Base");
            System.out.println("[2]-Analisar dados");
            System.out.println("[3]-Log");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("======================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }

    public int menuProcessarDados(){
        int opc = -1;

        do{
            System.out.println("========[Analisar Dados]========");
            System.out.println("[1]-Buscar por Autor");
            System.out.println("[2]-Buscar por Ano");
            System.out.println("[3]-Buscar por Título");
            System.out.println("[4]-Histórico de buscas");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }

    public int notificacoesLog(){
        int opc = -1;

        do{
            System.out.println("========[Log]========");
            System.out.println("[1]-Visualizar Notificações");
            System.out.println("[2]-Limpar Notificações");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("======================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }

    public int menuDeImportacaoBib(){
        int opc = -1;

        do{
            System.out.println("========[.bib]========");
            System.out.println("[1]-Listar todas as bases");
            System.out.println("[2]-Importar todas");
            System.out.println("[3]-Importar específica");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("======================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }




}

package view;

import model.Query;

import java.util.ArrayList;
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

    public int menuAnalisarDados(){
        int opc = -1;

        do{
            System.out.println("========[Analisar Dados]========");
            System.out.println("[1]-Buscar por Título");
            System.out.println("[2]-Buscar por Autor");
            System.out.println("[3]-Buscar por Ano");
            System.out.println("[4]-Query personalizada");
            System.out.println("[5]-Histórico de buscas");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }

    public int menuQuery(){
        int opc = -1;

        do{
            System.out.println("=========[Query]=========");
            System.out.println("[1]-Usar query existente");
            System.out.println("[2]-Criar query");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("=========================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;
        }while(opc!=0);
    }

    public Query meuCriarQuery(){
        sc.nextLine();//LimparScaner
        ArrayList<String> parametros = new ArrayList<>();
        System.out.println("=========[Criação]=========");
        System.out.println("Adicione os parâmetros");
        System.out.println();
        System.out.println("[0]-Sair");
        System.out.println("===========================");

        while(true){
            System.out.print("[Parametro]: ");
            String parametro = sc.nextLine();
            if(parametro.equals("0")){
                break;
            }
            parametros.add(parametro);
        }

        return new Query(parametros);
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
            System.out.println("[4]-Bases Importadas");
            System.out.println("[5]-Remover base específica");
            System.out.println("[6]-Remover toda a base");
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("======================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;

        }while(opc!=0);
    }

    public String menuDeImportacaoBib3(ArrayList<String> nomesBibs){
        int opc = -1;

        do{
            System.out.println("========[.bib]========");
            for(int i=0; i<nomesBibs.size();i++){
                System.out.println("["+(i+1)+"]-"+nomesBibs.get(i));
            }
            System.out.println();
            System.out.println("[0]-Sair");
            System.out.println("======================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return nomesBibs.get(opc-1);

        }while(opc!=0);
    }





}

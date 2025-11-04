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

    public int menuQuery(ArrayList<String> querys){
        int opc = -1;

        do{
            System.out.println("=========[Query]=========");

            for(int i=0; i<querys.size(); i++){
                System.out.println("["+i+"]"+ querys.get(i));
            }
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("["+(querys.size())+"]"+"-Remover query");
            System.out.println("["+(querys.size()+1)+"]"+"-Criar query");
            System.out.println("-------------------------");
            System.out.println();
            System.out.println("[0.1]-Sair");
            System.out.println("=========================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            return opc;
        }while(opc!=0.1);
    }

    public Query menuCriarQuery(){
        sc.nextLine();//LimparScaner
        ArrayList<String> parametros = new ArrayList<>();
        System.out.println("=========[Criação]=========");
        System.out.println("Adicione os parâmetros");
        System.out.println();
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

    public int menuRemoverQuery(ArrayList<String> querys){
        sc.nextLine();//LimparScaner
        ArrayList<String> parametros = new ArrayList<>();
        System.out.println("=========[Remoção]=========");
        for(int i=0; i<querys.size(); i++){
            System.out.println("["+i+"]"+ querys.get(i));
        }
        System.out.println();
        System.out.println("[0]-Sair");
        System.out.println("===========================");
        System.out.print("Selecione a query: ");
        int opc = sc.nextInt();


        return opc;
    }



    public String menuBuscar(String oqueBuscar){
        sc.nextLine();
        System.out.println("===============");
        System.out.print("Digite seu "+oqueBuscar+": ");
        String opc = sc.nextLine();
        return opc;
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

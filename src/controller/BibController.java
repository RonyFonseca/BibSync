package controller;

import servirces.LogServicos;
import model.Bib;
import model.Query;
import servirces.BibServices;
import servirces.QueryServices;
import view.MenusView;

import java.util.ArrayList;
import java.util.List;

public class BibController {
    private MenusView menus = new MenusView();
    private BibServices bibServices = new BibServices();
    private LogServicos logServicos = new LogServicos();
    private List<List<Bib>> importados;

    public void importacaoDaBase(){
        int opc =-1;
        do{
            opc = menus.menuDeImportacaoBib();
            switch (opc){
                case 0:
                    break;
                case 1:
                    ArrayList<String> nomes = bibServices.listarBibs();
                    System.out.println("Bibs encontrados:");
                    for(String n: nomes){
                        System.out.println(n);
                    }
                    break;
                case 2:
                    this.importados =  bibServices.importarBibs();
                    break;
                case 3:
                    String nomesEspecifico = menus.menuDeImportacaoBib3(bibServices.listarBibs());
                    if(nomesEspecifico != null){
                        this.importados = bibServices.importarBibs(nomesEspecifico);
                    }
                    break;
                case 4:
                    try{
                        for(String nome: bibServices.identificarImportados()){
                            System.out.println(nome+"-[importado]");
                        }
                    }catch (NullPointerException e){
                        System.out.println("Você ainda não importou nem uma base.");
                    }
                    break;
                case 5:

                    nomesEspecifico = menus.menuDeImportacaoBib3(bibServices.identificarImportados());
                    if(nomesEspecifico != null){
                        bibServices.removerBib(nomesEspecifico);
                    }
                    break;
                case 6:
                    bibServices.removerBib(null);
                    break;
                default:
                    System.out.println("Opção inválida !");
            }
        }while (opc!=0);
    }
    public void gerenciarLogs() {
        int opc = -1;
        do {
            opc = menus.notificacoesLog();
            switch (opc) {
                case 0:
                    break;      
                case 1:
                    logServicos.visualizarLogs();
                    break;
                case 2:
                    logServicos.limparLogs();
                    break;
                default:
                    System.out.println("Opção inválida !");
            }
        } while (opc != 0);
    }

    public void analisarDados(){
        int opc = -1;
        QueryServices queryServices = new QueryServices();
        do{
            opc = menus.menuAnalisarDados();
            switch (opc){
                case 1:
                    String titulo = menus.menuBuscar("titulo");
                    bibServices.procurarBib(1, titulo.toLowerCase());
                    break;
                case 2:
                    String autor = menus.menuBuscar("autor");
                    bibServices.procurarBib(2, autor.toLowerCase());
                    break;
                case 3:
                    String ano = menus.menuBuscar("ano");
                    bibServices.procurarBib(3, ano.toLowerCase());
                    break;
                case 4:
                    ArrayList<String> querys = queryServices.pegarQuerysSalvas();
                    opc = menus.menuQuery(querys);

                    if(opc!=(querys.size()+1) && opc!=querys.size()){
                        String[] converterParaArray = querys.get(opc).split("],");

                        queryServices.pesquisarArtigoPorQuery(converterParaArray);
                    }

                    if(opc==(querys.size()+1)){
                        Query query = menus.menuCriarQuery();
                        queryServices.salvarQuery(query.getParametros());
                    } else if (opc==querys.size()){
                        opc = menus.menuRemoverQuery(querys);
                        queryServices.removerQuery(opc);
                    }
                case 5:
                    queryServices.mostrarHistoricoQuerys();
                    break;
                default:
                    System.out.println("Opção inválida !");
            }
        }while(opc!= 0);
    }
}

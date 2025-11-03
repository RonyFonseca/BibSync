package controller;

import model.Bib;
import model.Query;
import servirces.BibServices;
import view.MenusView;

import java.util.ArrayList;
import java.util.List;

public class BibController {
    private MenusView menus = new MenusView();
    private BibServices bibServices = new BibServices();
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
                    this.importados = bibServices.importarBibs(nomesEspecifico);
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
                    bibServices.removerBib(nomesEspecifico);
                    break;
                case 6:
                    bibServices.removerBib(null);
                    break;
                default:
                    System.out.println("Opção inválida !");
            }
        }while (opc!=0);
    }

    public void analisarDados(){
        int opc = -1;
        do{
            opc = menus.menuAnalisarDados();
            switch (opc){
                case 4:
                    opc = menus.menuQuery();
                    Query query = menus.meuCriarQuery();
                    //QueryService
                    break;
                default:
                    System.out.println("Opção inválida !");
            }
        }while(opc!=0);
    }
}

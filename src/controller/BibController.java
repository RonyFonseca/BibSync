package controller;

import model.Bib;
import servirces.BibServices;
import view.MenusView;

import java.util.ArrayList;
import java.util.List;

public class BibController {
    private MenusView menus = new MenusView();
    private BibServices services = new BibServices();
    private List<List<Bib>> importados;
    //Persistência de dados;

    public void importacaoDaBase(){
        int opc =-1;
        do{
            opc = menus.menuDeImportacaoBib();
            switch (opc){
                case 1:
                    ArrayList<String> nomes = services.listarBibs();
                    System.out.println("Bibs encontrados:");
                    for(String n: nomes){
                        System.out.println(n);
                    }
                    break;
                case 2:
                    this.importados =  services.importarBibs();
                    break;
                case 3:
                    String nomesEspecifico = menus.menuDeImportacaoBib3(services.listarBibs());
                    this.importados = services.importarBibs(nomesEspecifico);
                    break;
                case 4:
                    try{
                        for(String nome: services.identificarImportados()){
                            System.out.println(nome+"-[importado]");
                        }
                    }catch (NullPointerException e){
                        System.out.println("Você ainda não importou nem uma base.");
                    }
                    break;
                case 5:
                    nomesEspecifico = menus.menuDeImportacaoBib3(services.identificarImportados());
                    services.removerBib(nomesEspecifico);
                    break;
                case 6:
                    services.removerBib(null);
                    break;
            }
        }while (opc!=0);
    }
}

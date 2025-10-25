package controller;

import servirces.BibServices;
import view.MenusView;

public class BibController {
    private MenusView menus = new MenusView();
    private BibServices services = new BibServices();
    //Persistência de dados;

    public void importacaoDaBase(){
        int opc = menus.menuDeImportacaoBib();
        switch (opc){
            case 1:
                services.ListarBibs();
        }
    }
}

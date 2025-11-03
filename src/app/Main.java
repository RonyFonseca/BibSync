package app;

import controller.BibController;
import servirces.BibServices;
import view.MenusView;

public class Main {
    public static void main(String[] args) {

        BibController bibController = new BibController();
        BibServices services = new BibServices();
        MenusView menus = new MenusView();
        bibController.analisarDados();

    }
}

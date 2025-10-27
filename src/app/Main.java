package app;

import controller.BibController;
import servirces.BibServices;
import view.MenusView;

public class Main {
    public static void main(String[] args) {

        BibController bibController = new BibController();
        bibController.importacaoDaBase();
    }
}

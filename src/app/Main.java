package app;

import controller.BibController;
import servirces.BibServices;
import view.MenusView;

public class Main {
    public static void main(String[] args) {

        BibServices services = new BibServices();
        services.identificarTipoBib();
    }
}

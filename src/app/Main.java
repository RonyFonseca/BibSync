package app;

import controller.BibController;
import view.MenusView;

public class Main {
    public static void main(String[] args) {

        BibController bibController = new BibController();
        MenusView menus = new MenusView();

        int opc;
        do {
            opc = menus.menuPrincipal();

            switch (opc) {
                case 1:
                    bibController.importacaoDaBase();
                    break;
                case 2:
                    bibController.analisarDados();
                    break;
                case 3:
                    bibController.gerenciarLogs();
                    break;
                case 0:
                    System.out.println("Saindo do BibSync... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opc != 0);
    }
}
package app;

import controller.BibController;
import view.MenusView;

public class Main {
    public static void main(String[] args) {

        BibController bibController = new BibController();
        MenusView menus = new MenusView();

        int opc;
        do {
            System.out.println("========================================\n" +
                    "   ____  _ _     ____                 \n" +
                    "  | __ )(_) |__ / ___| _   _ _ __   ___\n" +
                    "  |  _ \\| | '_ \\\\___ \\| | | | '_ \\ / __|\n" +
                    "  | |_) | | |_) |___) | |_| | | | | (__ \n" +
                    "  |____/|_|_.__/|____/ \\__, |_| |_|\\___|\n" +
                    "                       |___/            \n" +
                    "========================================\n" +
                    "        \uD83D\uDCDA Bem-vindo ao BibSync \uD83D\uDCDA\n" +
                    "  Sistema de análise e busca em bases .bib\n" +
                    "========================================" +
                    "\n");
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
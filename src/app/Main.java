package app;

import factory.Factory;
import factory.FactoryIEEE;
import factory.FactoryMDPI;
import model.Bib;
import servirces.BibServices;
import strategy.BibIEEE;
import strategy.BibMDPI;
import strategy.BibStrategy;
import strategy.Strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============");
        System.out.println("[1]-Ler os bibs");
        System.out.println("============");
        int opc = sc.nextInt();

        if(opc == 1){
            System.out.println("============");
            System.out.println("[1]-IEEE");
            System.out.println("[2]-MDPI");
            System.out.println("============");
            int opc2 = sc.nextInt();

            Strategy bibi;
            if(opc2 == 1){
                bibi = new BibIEEE();
            }else {
                bibi = new BibMDPI();
            }

            Factory tste = bibi.criarBib();
            List<Bib> artigos = tste.lerArquivo();
            for(Bib b: artigos){
                System.out.println(b);
            }

        }
    }
}

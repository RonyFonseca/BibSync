package factory;

import model.Bib;
import servirces.BibServices;

import java.util.List;

public interface Factory {
    String nome = "";
    BibServices services = null;
    List<Factory> lerArquivo();
    String getNome();
    String getFonte();
}

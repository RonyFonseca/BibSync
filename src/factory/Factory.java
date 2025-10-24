package factory;

import servirces.BibServices;

import java.util.List;

public interface Factory {
    BibServices services = null;
    List<model.Bib> lerArquivo();
    String getFonte();
}

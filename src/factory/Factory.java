package factory;

import model.Bib;
import servirces.BibServices;

import java.util.List;

public interface Factory {
    BibServices services = null;
    List<List<Bib>> lerArquivo();
    String getFonte();
}

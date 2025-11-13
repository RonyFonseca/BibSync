package strategy;
import model.Bib;
import java.util.ArrayList;
import java.util.List;


public interface Strategy {
    void filtrar(List<Bib> bibs);
}

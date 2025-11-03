package observer;

import java.util.ArrayList;
import java.util.List;

public class LogMeneger implements Subject{
    List<Observer> observadores = new ArrayList<>();

    @Override
    public void adicionarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void notificarObservadores(String msg) {
        for(Observer o: observadores){
            o.atualizar(msg);
        }
    }
}

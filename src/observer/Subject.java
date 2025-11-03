package observer;

public interface Subject {
    void adicionarObservador(Observer o);
    void removerObservador(Observer o);
    void notificarObservadores(String msg);
}

package model;

import java.util.ArrayList;

public class Query {
    private ArrayList<String> parametros;

    public Query(ArrayList<String> parametros) {
        this.parametros = parametros;
    }


    public ArrayList<String> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<String> parametros) {
        this.parametros = parametros;
    }

    @Override
    public String toString() {
        return "Query{parametros =" + parametros +'}';
    }
}

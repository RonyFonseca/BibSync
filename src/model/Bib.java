package model;

public class Bib {
    private String titulo;
    private String ano;
    private String autor;
    private String resumo;
    private String doi;
    private String url;

    public Bib(String titulo, String ano, String autor, String resumo, String doi, String url) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.resumo = resumo;
        this.doi = doi;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Bib{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", autor='" + autor + '\'' +
                ", resumo='" + resumo + '\'' +
                ", Doi='" + doi + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

package com.appspot.omagnoendpoints.backend;

/**
 * Created by oswaldosaldivar on 15/05/16.
 */
public class Saludo {
    private String texto;
    public Saludo() {}
    public Saludo(String texto) {
        this.texto = texto;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
}

package com.appspot.omagnoendpoints.backend;

/**
 * Created by oswaldosaldivar on 15/05/16.
 */
public class Nombres {
    private String nombre1;
    private String nombre2;
    public Nombres() {}
    public Nombres(String nombre1, String nombre2) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }
    public String getNombre1() {
        return nombre1;
    }
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }
    public String getNombre2() {
        return nombre2;
    }
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
}

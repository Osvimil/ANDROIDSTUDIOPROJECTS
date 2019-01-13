package com.hotmail.oswaldoadidas.ejemplodrawer;

/**
 * Created by oswaldosaldivar on 29/04/16.
 */
public class Item {

    String titulos;
    int iconos;


    public Item(String titulos,int iconos){

        this.titulos=titulos;
        this.iconos=iconos;
    }

    public String getTitulos(){
        return titulos;
    }

    public int getIconos(){
        return  iconos;
    }

    public void setTitulos(String titulos){
        this.titulos=titulos;
    }

    public void setIconos(int iconos){
        this.iconos=iconos;
    }

}

package com.hotmail.oswaldoadidas.ejemplodrawer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oswaldosaldivar on 01/05/16.
 */
public class NavigatorAdapter extends BaseAdapter {

    AppCompatActivity activity;
    ArrayList<Item> arrayList;


    public NavigatorAdapter(AppCompatActivity activity, ArrayList<Item> arrayList){
        super();
        this.activity=activity;
        this.arrayList=arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fila view;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(convertView==null){
            view = new Fila();
            Item item = arrayList.get(position);

            convertView = inflater.inflate(R.layout.item,null);
            view.titulo = (TextView)convertView.findViewById(R.id.texto);
            view.titulo.setText(item.getTitulos());

            view.icono = (ImageView)convertView.findViewById(R.id.icon);
            view.icono.setImageResource(item.getIconos());
            convertView.setTag(view);

        }else{
            view = (Fila)convertView.getTag();
        }
        return convertView;
    }


    public static class Fila{

        TextView titulo;
        ImageView icono;

    }
}

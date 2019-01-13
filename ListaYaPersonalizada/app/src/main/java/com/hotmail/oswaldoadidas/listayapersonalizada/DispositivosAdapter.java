package com.hotmail.oswaldoadidas.listayapersonalizada;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by oswaldosaldivar on 25/04/16.
 */
public class DispositivosAdapter extends ArrayAdapter<Dispositivos> {
    Context myContext;
    int myLayout;
    Dispositivos myData[]=null;


    public DispositivosAdapter(Context context,int layout,Dispositivos[]datos){
        super(context,layout,datos);

        this.myContext=context;
        this.myLayout=layout;
        this.myData=datos;

    }

    public View getView(int position,View convertView,ViewGroup parent){
        View row = convertView;
        DispositivosHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row= inflater.inflate(myLayout,parent,false);

            holder= new DispositivosHolder();
            holder.imageView= (ImageView)row.findViewById(R.id.imagenes);
            holder.textView = (TextView)row.findViewById(R.id.textview);
            row.setTag(holder);

        }else{
            holder = (DispositivosHolder)row.getTag();

        }
        Dispositivos dispositivos = myData[position];
        holder.textView.setText(dispositivos.title);
        holder.imageView.setImageResource(dispositivos.icon);
        return row;

    }

    static class DispositivosHolder{
        ImageView imageView;
        TextView textView;
    }
}

package com.hotmail.oswaldosaldivar.listonapersonalizada;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by oswaldosaldivar on 13/03/16.
 */
public class FrutasVerdurasAdapter extends ArrayAdapter<FrutasVerduras>{
    Context mycontext;
    int mylayoutresourceid;
    FrutasVerduras mydata[] = null;

    public FrutasVerdurasAdapter(Context context, int layoutresourceid, FrutasVerduras[]data){
        super(context,layoutresourceid,data);

        this.mycontext = context;
        this.mylayoutresourceid=layoutresourceid;
        this.mydata=data;
    }

    public View getView(int position, View convertview, ViewGroup parent){
        View row = convertview;
        FrutasVerdurasHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row= inflater.inflate(mylayoutresourceid,parent,false);

            holder = new FrutasVerdurasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView)row.findViewById(R.id.texto);
            row.setTag(holder);

        }else{
            holder=(FrutasVerdurasHolder)row.getTag();


        }
        FrutasVerduras frutasVerduras = mydata[position];
        holder.texto.setText(frutasVerduras.title);
        holder.imagen.setImageResource(frutasVerduras.icon);
        return null;

    }
    static class FrutasVerdurasHolder{
        ImageView imagen;
        TextView texto;


    }
}

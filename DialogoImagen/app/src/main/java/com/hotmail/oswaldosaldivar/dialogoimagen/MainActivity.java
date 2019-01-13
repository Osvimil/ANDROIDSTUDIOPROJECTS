package com.hotmail.oswaldosaldivar.dialogoimagen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int d){
        Dialog dialogo = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.pop);
        builder= builder.setTitle("Imagen y dialogo");
        dialogo = builder.create();

        return dialogo;


    }


    @Override
    public void onClick(View v) {
        onCreateDialog(0).show();

    }
}

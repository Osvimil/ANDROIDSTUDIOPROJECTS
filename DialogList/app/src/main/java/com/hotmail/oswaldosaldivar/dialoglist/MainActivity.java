package com.hotmail.oswaldosaldivar.dialoglist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button nombres;
    String []paises = {"PHP","C","C++","RUBY","PYTHON","OBJETIVE C","JAVA","HTML","JAVASCRIPT","COBOL","FORTRAN","PASCAL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (Button)findViewById(R.id.nombres);

        nombres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("que lenguaje te gusta?");
                builder.setItems(paises, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Te gusta este lenguaje: "+paises[which], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}

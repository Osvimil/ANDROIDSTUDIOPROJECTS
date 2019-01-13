package com.hotmail.oswaldosaldivar.dialogo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button)findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert of exit");
                builder.setMessage("ARE YOU SURE YOU WANT GO GO OUT HERE?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

                            }
                        }
                );
            builder.setNegativeButton("No", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}

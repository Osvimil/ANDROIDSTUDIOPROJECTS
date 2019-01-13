package com.hotmail.oswaldosaldivar.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton_login);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Login dialog");
                dialog.setContentView(R.layout.item_login_layout);
                dialog.show();


                final EditText editText = (EditText)dialog.findViewById(R.id.edit);
                Button submit = (Button)dialog.findViewById(R.id.submit);
                Button cancel = (Button)dialog.findViewById(R.id.cancel);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = editText.getText().toString();
                        Toast.makeText(getApplicationContext(),"pin submited is: "+text,Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });



            }
        });
    }
}

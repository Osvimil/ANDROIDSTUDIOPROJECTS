package com.hotmail.oswaldosaldivar.dialogoprogress;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("DOWNLOAD");
                progressDialog.setMessage("Downloading, please wait some minutes");
                //progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });
    }
}

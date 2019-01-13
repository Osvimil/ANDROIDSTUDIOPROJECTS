package com.hotmail.oswaldosaldivar.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;

    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.opc1:
                Toast.makeText(getApplicationContext(),"Item 1",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.opcion2:
                Toast.makeText(getApplicationContext(),"Item 2",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn1:
                Toast.makeText(getApplicationContext(),"boton 1",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                Toast.makeText(getApplicationContext(),"boton 2",Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn3:
                Toast.makeText(getApplicationContext(),"boton 3",Toast.LENGTH_SHORT).show();

                break;

        }

    }
}

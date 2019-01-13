package com.hotmail.oswaldosaldivar.actionsbars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEPURACION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.settings:
                Log.d(TAG,"DEPURANDO ANDO");
                return true;
            case R.id.buscar:
                Log.i("Buscar","B");
                return true;
            case R.id.nuevo:
                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);



        }

    }
}

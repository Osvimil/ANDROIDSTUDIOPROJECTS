package com.hotmail.oswaldosaldivar.iconizando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){

            case R.id.item1:
                Toast.makeText(getApplicationContext(),"SETTING",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(getApplicationContext(),"ITEM 1",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(getApplicationContext(),"ITEM 2",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);


        }


    }


}

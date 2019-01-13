package com.hotmail.oswaldoadidas.vistasdelistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] gatos = {"negros","blancos","amarillos","café","dorados","grises"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listillas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,gatos);
        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}

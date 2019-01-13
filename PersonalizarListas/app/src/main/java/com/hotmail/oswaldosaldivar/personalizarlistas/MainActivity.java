package com.hotmail.oswaldosaldivar.personalizarlistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher,"gansos"),
                new Bandas(R.drawable.ic_launcher,"pedros"),
                new Bandas(R.drawable.ic_launcher,"los salas"),
                new Bandas(R.drawable.ic_launcher,"megafonos"),
                new Bandas(R.drawable.ic_launcher,"transexuales"),
                new Bandas(R.drawable.ic_launcher,"the nirvanna"),
                new Bandas(R.drawable.ic_launcher,"las papayas"),
                new Bandas(R.drawable.ic_launcher,"calabazas"),
                new Bandas(R.drawable.ic_launcher,"tigres del nore"),

        };

        BandasAdapter adapter = new BandasAdapter(this, R.layout.listview_item_row,bandas_data);
        list = (ListView) findViewById(R.id.lista);
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        list.addHeaderView(header);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v =(TextView) findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}

package com.hotmail.oswaldoadidas.listayapersonalizada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dispositivos dispositivos_datos[]= new Dispositivos[]{
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"Celular"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"smartTV"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"Tablet"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"SmartWatch"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"Fablet"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"Wearable"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"Ipod"),
                new Dispositivos(R.drawable.ic_important_devices_black_48dp,"PC"),

        };

        DispositivosAdapter adapter = new DispositivosAdapter(this,R.layout.listview_item_row,dispositivos_datos);
        listView = (ListView)findViewById(R.id.listillas);
        View header = (View)getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)findViewById(R.id.textview);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

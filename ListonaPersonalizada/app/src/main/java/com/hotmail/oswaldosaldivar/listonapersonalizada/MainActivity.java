package com.hotmail.oswaldosaldivar.listonapersonalizada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listilla = (ListView)findViewById(R.id.listilla);

        FrutasVerduras frutasVerduras_datos[] = new FrutasVerduras[]{

                new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        new FrutasVerduras(R.drawable.wifi,"MANZANA"),
        };

        FrutasVerdurasAdapter adapter = new FrutasVerdurasAdapter(this,R.layout.listview_item_row,frutasVerduras_datos);

        View header = (View) getLayoutInflater().inflate(R.layout.listview_item_header,null);
        listilla.addHeaderView(header);
        listilla.setAdapter(adapter);

        listilla.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.texto);

                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

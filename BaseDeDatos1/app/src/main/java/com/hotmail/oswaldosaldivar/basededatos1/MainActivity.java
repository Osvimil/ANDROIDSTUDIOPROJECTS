package com.hotmail.oswaldosaldivar.basededatos1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper mybase;
    EditText editname;
    EditText editapellidos;
    EditText editmaterias;
    EditText editid;
    Button boton;
    Button boton1;
    Button actualizar;
    Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybase = new DataBaseHelper(this);

        editname = (EditText)findViewById(R.id.editnombre);
        editapellidos = (EditText)findViewById(R.id.editapellidos);
        editmaterias = (EditText)findViewById(R.id.editmaterias);
        editid= (EditText)findViewById(R.id.editid);
        boton = (Button)findViewById(R.id.boton);
        boton1 = (Button)findViewById(R.id.ver);
        actualizar = (Button)findViewById(R.id.actualizar);
        borrar = (Button)findViewById(R.id.borrar);
        agregarDatos();
        viewAll();
        UpdateDate();
        BorrarDatos();

    }
    public void BorrarDatos(){
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer borrarFilas = mybase.deleteDates(editid.getText().toString());
                if(borrarFilas>0){
                    Toast.makeText(MainActivity.this,"DATOS BORRADOS",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"DATOS NO BORRADOS",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void UpdateDate() {
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mybase.updateDates(editid.getText().toString()
                ,editname.getText().toString(),editapellidos.getText().toString()
                        ,editmaterias.getText().toString());
                if(isUpdate==true)
                {
                    Toast.makeText(MainActivity.this, "DATOS ACTUALIZADOS", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "DATOS NO ACTUALIZADOS", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void agregarDatos(){

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insertado = mybase.insertData(editname.getText().toString(),
                        editapellidos.getText().toString(),
                        editmaterias.getText().toString());

                if (insertado == true) {
                    Toast.makeText(MainActivity.this, "DATOS INSERTADOS", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "DATOS NO INSERTADOS", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void viewAll(){

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mybase.getAllData();
                if(res.getCount()==0){
                    getMessage("ERROR","NOTHING HAS BEEN FOUND");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("NOMBRE :"+res.getString(1)+"\n");
                    buffer.append("APELLIDOS :"+res.getString(2)+"\n");
                    buffer.append("MATERIAS :"+res.getString(3)+"\n\n");
                }
                getMessage("DATA",buffer.toString());

            }

        });
    }

    public void getMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }



}

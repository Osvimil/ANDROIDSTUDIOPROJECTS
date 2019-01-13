package com.hotmail.oswaldoadidas.formulariorapido;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.edit1);
        editText2=(EditText)findViewById(R.id.edit2);
        textView=(TextView)findViewById(R.id.textview3);
    }

    public void validar(View view){
        textView.setText(editText1.getText().toString()+" "+editText2.getText().toString());

    }
}

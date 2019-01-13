package oswaldoadidas.hotmail.com.firebasepush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    String valor = "no hay mensaje ahora";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);

        if(getIntent().getExtras() != null){
            valor = getIntent().getExtras().getString("mensaje");

            if(valor == null){
                valor = "No hay nuevos mensajes";

            }

        }

        textView1.setText("SMS: "+valor);


    }
}

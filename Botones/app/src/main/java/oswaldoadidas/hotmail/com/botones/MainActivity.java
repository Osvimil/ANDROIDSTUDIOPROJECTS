package oswaldoadidas.hotmail.com.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button onLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onLong = (Button) findViewById(R.id.setOnLong);
        onLong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(),"SETON LONG",Toast.LENGTH_SHORT).show();
                return false;
            }
        });



        Button setOn = (Button) findViewById(R.id.setOnClick);
        setOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"SETON CLICK",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view){
        Toast.makeText(getBaseContext(),"ONCLICK BUTTON",Toast.LENGTH_SHORT).show();

    }
}

package oswaldoadidas.hotmail.com.brightness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*SeekBar seekBar;
    Context context;
    int brillo;*/

    private static SeekBar seekBar;
    private static TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metodon();
    }


    public void metodon(){

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Cubierto: "+seekBar.getProgress()+" / "+seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int valorProgreso;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorProgreso = progress;
                textView.setText("Cubierto: "+progress+" / "+seekBar.getMax());
                Toast.makeText(MainActivity.this,"en progreso",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"comenzando",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Cubierto: "+valorProgreso+" / "+seekBar.getMax());
                Toast.makeText(MainActivity.this,"parado",Toast.LENGTH_SHORT).show();

            }
        });
    }

        /*
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        context = getApplicationContext();
        //brillo = Settings.System.getInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);
        brillo = Settings.System.getInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);

        seekBar.setProgress(brillo);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,progress);
                Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/
}

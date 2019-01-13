package oswaldoadidas.hotmail.com.drawerlayoutzero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by oswaldosaldivar on 30/04/17.
 */

public class Navegar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navegar);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navegado);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

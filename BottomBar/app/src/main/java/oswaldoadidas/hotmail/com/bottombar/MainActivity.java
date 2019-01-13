package oswaldoadidas.hotmail.com.bottombar;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.OnMenuTabClickListener;


public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = BottomBar.attach(this,savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int i) {
                if(i == R.id.BottonUno){
                    DedosFragment f = new DedosFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();

                }else if(i == R.id.BottonDos){
                    TraduccionFragment f = new TraduccionFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();


                }else if(i == R.id.BottonTres){
                    JuezFragment f = new JuezFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }else if(i == R.id.BottonCuatro){
                    AbrirFragment f = new AbrirFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }else if(i == R.id.BottonCinco){
                    AquiFragment f = new AquiFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {


            }
        });
        bottomBar.mapColorForTab(0,"#F44336");
        bottomBar.mapColorForTab(1,"#9C27B0");
        bottomBar.mapColorForTab(2,"#03A9F4");
        bottomBar.mapColorForTab(3,"#795548");
        bottomBar.mapColorForTab(4,"#FF6F00");

        BottomBarBadge unread;
        unread = bottomBar.makeBadgeForTabAt(3,"#FF0000",13);
        unread.show();

    }
}

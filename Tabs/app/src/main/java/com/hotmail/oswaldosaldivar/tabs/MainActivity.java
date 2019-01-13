package com.hotmail.oswaldosaldivar.tabs;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tab = (TabLayout)findViewById(R.id.tabs);
        ViewPager views = (ViewPager)findViewById(R.id.pager);

        views.setAdapter(new SectionPageAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(views);


    }



    public class SectionPageAdapter extends FragmentPagerAdapter{

       public SectionPageAdapter(FragmentManager fm){
           super(fm);

       }

       @Override
       public android.support.v4.app.Fragment getItem(int position) {

           switch (position){
               case 0:
                   return new FragmentoA();
               case 1:
                   return new FragmentoB();
               default:
                   return new FragmentoC();

           }
       }

       @Override
       public int getCount() {
           return 2;
       }

        @Override
       public CharSequence getPageTitle(int position){
            switch (position){

                case 0:
                    return "Numero 1";
                case 1:
                    return "Numero 2";
                default:
                    return "Es otro paps";
            }

        }
   }

}

package com.hotmail.oswaldoadidas.fragmentontin;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    public class SectionPagerAdapter extends FragmentPagerAdapter{
        public SectionPagerAdapter(FragmentManager fm){
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {


            switch (position){

                case 0:
                    return new Ruby();
                case 1:
                    return new Python();
                case 2:
                    return new Java();
                case 3:
                    return new Go();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position){

            switch (position){

                case 0:
                    web = (WebView)findViewById(R.id.web);

                    web.loadUrl("http://youtube.com");

                    web.setWebViewClient(new WebViewClient()
                                         {
                                             public boolean shouldOverrideUrlLoading(WebView view, String url){
                                                 return false;
                                             }
                                         }
                    );
                    return "RUBY";

                case 1:
                    return "PYTHON";
                case 2:
                    return "JAVA";
                case 3:
                    return "GO";


            }
            return null;
        }

    }





}

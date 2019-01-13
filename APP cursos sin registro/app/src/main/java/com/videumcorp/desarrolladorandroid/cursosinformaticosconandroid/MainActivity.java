package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.AcercaDe;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.ArchivosPdf;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.Registrate;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.Settings;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos.FragmentCursos;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos.premium.FragmentCursosPremium;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        //First fragment
        setFragment(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_eye:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_user:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_open:
                                menuItem.setChecked(true);
                                setFragment(2);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_close:
                                menuItem.setChecked(true);
                                setFragment(3);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_pdf:
                                menuItem.setChecked(true);
                                setFragment(4);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;

                            case R.id.item_navigation_drawer_message:
                                menuItem.setChecked(true);
                                //setFragment(5);
                                Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.item_navigation_drawer_help:
                                menuItem.setChecked(true);
                                setFragment(5);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                AcercaDe acercaDe = new AcercaDe();
                fragmentTransaction.replace(R.id.fragment, acercaDe);
                break;
            case 1:
                Registrate registrate = new Registrate();
                fragmentTransaction.replace(R.id.fragment, registrate);
                break;
            case 2:
                FragmentCursos cursosBasicos = new FragmentCursos();
                fragmentTransaction.replace(R.id.fragment,cursosBasicos);
                break;
            case 3:
                FragmentCursosPremium cursosPremium = new FragmentCursosPremium();
                fragmentTransaction.replace(R.id.fragment,cursosPremium);
                break;
            case 4:
                ArchivosPdf archivosPdf = new ArchivosPdf();
                fragmentTransaction.replace(R.id.fragment,archivosPdf);
                break;
            case 5:
                Settings settings = new Settings();
                fragmentTransaction.replace(R.id.fragment,settings);
                break;

        }
        fragmentTransaction.commit();
    }
}


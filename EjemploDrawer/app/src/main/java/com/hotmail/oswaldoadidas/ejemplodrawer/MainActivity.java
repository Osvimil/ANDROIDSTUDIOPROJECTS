package com.hotmail.oswaldoadidas.ejemplodrawer;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView listView;
    TypedArray myIcons;
    String[] titulos;
    ArrayList<Item> navItems;
    NavigatorAdapter navigatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        listView=(ListView)findViewById(R.id.listview);

        View header = getLayoutInflater().inflate(R.layout.header,null);
        listView.addHeaderView(header);

        myIcons = getResources().obtainTypedArray(R.array.icons);
        titulos = getResources().getStringArray(R.array.titulos);


        navItems = new ArrayList<Item>();

        navItems.add(new Item(titulos[0],myIcons.getResourceId(0,-1)));
        navItems.add(new Item(titulos[1],myIcons.getResourceId(1,-1)));
        navItems.add(new Item(titulos[2],myIcons.getResourceId(2,-1)));
        navItems.add(new Item(titulos[3],myIcons.getResourceId(3,-1)));
        navItems.add(new Item(titulos[4],myIcons.getResourceId(4,-1)));
        navItems.add(new Item(titulos[5],myIcons.getResourceId(5,-1)));
        navItems.add(new Item(titulos[6],myIcons.getResourceId(6,-1)));
        navItems.add(new Item(titulos[7],myIcons.getResourceId(7,-1)));


        navigatorAdapter = new NavigatorAdapter(this,navItems);
        listView.setAdapter(navigatorAdapter);
    }
}

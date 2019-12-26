package com.patronusstudio.cargotracker.Activity;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.patronusstudio.cargotracker.Fragment.FragmentCargoes;
import com.patronusstudio.cargotracker.Fragment.Exit;
import com.patronusstudio.cargotracker.Fragment.ProfileSettings;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.personnel;

import java.util.List;

public class UserHome extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private personnel user;
    private DrawerLayout drawer;
    private TextView txt_nav_isim, txt_nav_email;
    private NavigationView navigationView;
    private List<cargoes> list;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        getData();
        toolbar();
        init();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentCargoes(list))
                .commit();

    }

    private void toolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView nav_header_isim = (TextView) headerView.findViewById(R.id.nav_header_isim);
        TextView nav_header_mail = (TextView) headerView.findViewById(R.id.nav_header_mail);
        nav_header_isim.setText(user.getName()+" "+user.getSurname());
        nav_header_mail.setText(user.getEmail());
    }

    private void init(){
        navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void getData() {
        user = getIntent().getExtras().getParcelable("personnel");
        list=getIntent().getExtras().getParcelableArrayList("list");

        Log.d("Sülo",list.size()+"");

        getIntent().removeExtra("personnel");
        getIntent().removeExtra("list");
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_cargo :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentCargoes(list))
                        .commit();
                break;
            case R.id.nav_person :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileSettings(user))
                        .commit();
                break;
            case R.id.nav_exit :
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

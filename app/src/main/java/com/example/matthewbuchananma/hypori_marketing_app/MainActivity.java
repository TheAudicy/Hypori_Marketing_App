package com.example.matthewbuchananma.hypori_marketing_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                    new InformationFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_information);
        }
    }


    public void hyporiTrialAndroid(View view) {
        Intent marketIntent = new Intent(Intent.ACTION_VIEW);
        marketIntent.setData(Uri.parse("market://details?id=com.intelligentwaves.client"));
        try {
            startActivity(marketIntent);
        }
        catch(Exception e){
            marketIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.intelligentwaves.client&hl=en_US"));
            startActivity(marketIntent);
        }
    }

    public void hyporiTrialApple(View view) {
        Intent marketIntent = new Intent(Intent.ACTION_VIEW);
        marketIntent.setData(Uri.parse("https://itunes.apple.com/us/app/hypori-client/id1309884013?mt=8"));
        startActivity(marketIntent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_information:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new InformationFragment()).commit();
                break;
            case R.id.nav_solution:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new SolutionFragment()).commit();
                break;
            case R.id.nav_benefits:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new WhyHyporiFragment()).commit();
                break;
            case R.id.nav_enterprise:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new EnterpriseFragment()).commit();
                break;
            case R.id.nav_experience:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new ExperienceFragment()).commit();
                break;
            case R.id.nav_system_requirements:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new ContactFragment()).commit();
                break;
            case R.id.nav_iw:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter,
                        new IntelligentWavesFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}

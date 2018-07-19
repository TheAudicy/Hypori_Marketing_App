package com.example.matthewbuchananma.hypori_marketing_app;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

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
                        new BenefitsFragment()).commit();
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
                        new SystemRequirementsFragment()).commit();
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

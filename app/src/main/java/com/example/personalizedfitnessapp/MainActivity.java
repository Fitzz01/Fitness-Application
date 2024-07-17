package com.example.personalizedfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        displayFragment(0);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeDashboard()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeDashboard()).commit();
                displayFragment(0);
                break;

            case R.id.nav_featuresExercise:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new featuresExercise()).commit();
                displayFragment(1);
                break;

            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new aboutApp()).commit();
                displayFragment(2);
                break;

            case R.id.nav_logout:
                exitPressed();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //method to display dialog message for logout
    public void exitPressed(){

        new AlertDialog.Builder(this)
                .setMessage("Are sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    //method to change toolbar title on each of fragments
    private void displayFragment(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        String title = "";
        switch (position) {
            case 0:
                fragment = new homeDashboard();
                title = "Dashboard";
                break;
            case 1:
                fragment = new featuresExercise();
                title = "Tools";
                break;
            case 2:
                fragment = new aboutApp();
                title = "About";
                break;

            default:
                break;
        }

        // update selected fragment and title
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit(); //replace with id of your frame container
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
package com.example.lagnewexin;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lagnewexin.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        // return NavigationUI.navigateUp(navController, appBarConfiguration)
        //        || super.onSupportNavigateUp();
        return true;
    }
    public void actionGo(View A) {
        Spinner spnAutor = (Spinner) findViewById(R.id.sprOptions1);
        Spinner spnGrade = (Spinner) findViewById(R.id.sprOptions2);
        Intent Ir;
        switch (spnAutor.getSelectedItem().toString()) {
            case "Newton":
                if (spnGrade.getSelectedItem().toString().equals("Linear")) {
                    Ir = new Intent(this, newtonLinear.class);
                    startActivity(Ir);
                } else {
                    Ir = new Intent(this, newtonCuadratico.class);
                    startActivity(Ir);
                }
                break;
            case "Lagrange":
                if (spnGrade.getSelectedItem().toString().equals("Linear")) {
                    Ir = new Intent(this, lagrangeLinear.class);
                    startActivity(Ir);
                } else {
                    Ir = new Intent(this, lagrangeCuadratico.class);
                    startActivity(Ir);
                }
                break;
        }
    }
}
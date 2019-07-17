package com.kidus.alc4phase1challenge1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button buttonAboutALC = (Button) findViewById(R.id.button_about_alc);
        buttonAboutALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutALC();
            }
        });

        Button buttonMyProfile = (Button) findViewById(R.id.button_my_profile);
        buttonMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyProfile();
            }
        });
    }

    private void openMyProfile() {
        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }

    private void openAboutALC() {
        Intent intent = new Intent(this, AboutALCActivity.class);
        startActivity(intent);
    }
}
package com.example.alc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLinkToAbout, btnLinkToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnLinkToAbout = findViewById(R.id.btn_link_to_alc_about);
        btnLinkToProfile = findViewById(R.id.btn_link_to_profile);
        btnLinkToProfile.setOnClickListener(this);
        btnLinkToAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLinkToAbout) {
            launchPage(AboutALC.class);
            return;
        }
        if (v == btnLinkToProfile) {
            launchPage(MyProfile.class);
        }
    }

    private void launchPage(Class newPage) {
        Intent newPageIntent = new Intent(MainActivity.this, newPage);
        startActivity(newPageIntent);
    }
}

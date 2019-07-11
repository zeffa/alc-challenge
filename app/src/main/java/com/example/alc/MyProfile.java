package com.example.alc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {
    private TextView txtName, txtTrack, txtCountry, txtEmail, txtPhoneNumber, txtSlackUsername;
    private ImageView imgProfilePic;
    private static final String TRACK = "Android";
    private static final String COUNTRY = "Kenya";
    private static final String EMAIL = "zeffah.elly@gmail.com";
    private static final String PHONE_NUMBER = "254736266532";
    private static final String SLACK_USERNAME = "@zeffah";
    private static final String FULL_NAME = "Elijah Onduso";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        init();
    }

    private void init() {
        txtCountry = findViewById(R.id.txt_country);
        txtName = findViewById(R.id.txt_name);
        txtTrack = findViewById(R.id.txt_track);
        txtEmail = findViewById(R.id.txt_email);
        txtPhoneNumber = findViewById(R.id.txt_phone_number);
        txtSlackUsername = findViewById(R.id.txt_slack_username);
        imgProfilePic = findViewById(R.id.img_profile_picture);

        setViewData();
        loadProfileImage();
    }

    private void setViewData() {
        txtName.setText(FULL_NAME);
        txtTrack.setText(String.format("Track: %s", TRACK));
        txtCountry.setText(String.format("Country: %s", COUNTRY));
        txtEmail.setText(String.format("Email: %s", EMAIL));
        txtPhoneNumber.setText(String.format("Phone Number: %s", PHONE_NUMBER));
        txtSlackUsername.setText(String.format("Slack Username: %s", SLACK_USERNAME));
    }


    private void loadProfileImage(){
        imgProfilePic.setImageResource(R.mipmap.zeff);
    }
}

package com.example.instagramclone.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instagramclone.R;
import com.example.instagramclone.ui.login.LoginActivity;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogoutButton(View view) {

        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

        if(currentUser != null) {
            ParseUser.logOut();
            goToLoginActivity();
        }

    }

    private void goToLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}

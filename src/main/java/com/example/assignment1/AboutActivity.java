package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Add any additional setup code for the AboutActivity here
    }

    public void goBackToMainActivity(View view) {
        // Implement the logic to go back to the main activity using Intent
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: finish the current activity
    }
}

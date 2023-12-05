package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Find the toolbar in the layout
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Set the toolbar as the support action bar
        setSupportActionBar(toolbar);

        // Set the title for the toolbar
        getSupportActionBar().setTitle("Contact Us");
    }
}

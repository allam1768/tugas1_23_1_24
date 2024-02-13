package com.example.tugas1_23_1_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button logout = findViewById(R.id.logout);

        // Set click listener for KALKULATOR button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to Kalkulator activity
                Intent intent = new Intent(home.this, Kalkulator.class);
                startActivity(intent);
            }
        });

        // Set click listener for button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define the logic to navigate to another activity (if needed)
            }
        });

        // Set click listener for button3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Define the logic to navigate to another activity (if needed)
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogout();
            }
        });
    }

    private void showLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout")
                .setMessage("Anda yakin mau logout ?")  // Fix syntax error here
                .setPositiveButton("Ya", (dialog, which) -> {
                    Intent intent = new Intent(home.this, MainActivity.class);
                    startActivity(intent);
                })
                .show();
    }
}

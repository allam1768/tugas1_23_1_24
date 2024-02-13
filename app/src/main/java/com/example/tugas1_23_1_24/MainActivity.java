package com.example.tugas1_23_1_24;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen lainnya
        usernameEditText = findViewById(R.id.txtusername);
        passwordEditText = findViewById(R.id.txtpassword);

        // ... Bagian inisialisasi lainnya ...

        ImageView showPasswordImageView = findViewById(R.id.showPasswordImageView);
        showPasswordImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePasswordVisibility();
            }
        });

        Button btnMasuk = findViewById(R.id.btnmasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    public void togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;

        if (isPasswordVisible) {
            // Tampilkan teks password
            passwordEditText.setTransformationMethod(null);
        } else {
            // Sembunyikan teks password
            passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    private void checkLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            // Menampilkan pesan jika username atau password kosong
            Toast.makeText(this, "Isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show();
        } else {
            // Cek login, misalnya dengan membandingkan dengan nilai yang sudah ditentukan
            if (password.equals(username)) {
                showLoginSuccessDialog();

            } else {
                // Menampilkan pesan login gagal
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showLoginSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login Berhasil")
                .setMessage("Selamat datang " + usernameEditText.getText().toString())
                .setPositiveButton("OK", (dialog, which) -> {
                    // Clearing the username and password fields
                    usernameEditText.setText("");
                    passwordEditText.setText("");

                    // Intent to move to the next activity
                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                })
                .show();
    }
}
package com.example.tugas1_23_1_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Kalkulator extends AppCompatActivity {

    private EditText input1, input2;
    private Spinner operatorSpinner;
    private Button hasilButton, kembali;
    private TextView hasilTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        // Initialize UI components
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        operatorSpinner = findViewById(R.id.operator);
        hasilButton = findViewById(R.id.buttonhasil);
        hasilTextView = findViewById(R.id.hasil);
        kembali = findViewById(R.id.kembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kalkulator.this, home.class);
                finish();
            }
        });


        hasilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if input fields are empty
                if (input1.getText().toString().isEmpty() || input2.getText().toString().isEmpty()) {
                    Toast.makeText(Kalkulator.this, "masukkan angka terlebuh dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get input values and selected operator
                double value1 = Double.parseDouble(input1.getText().toString());
                double value2 = Double.parseDouble(input2.getText().toString());
                String selectedOperator = operatorSpinner.getSelectedItem().toString();

                // Perform calculation based on the operator
                double result = 0;
                switch (selectedOperator) {
                    case "Tambah":
                        result = value1 + value2;
                        break;
                    case "Kurang":
                        result = value1 - value2;
                        break;
                    case "Kali":
                        result = value1 * value2;
                        break;
                    case "Bagi":
                        if (value2 != 0) {
                            result = value1 / value2;
                        } else {
                            Toast.makeText(Kalkulator.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }

                // Display the result
                setResultText("Hasil: " + result);
            }

            private void setResultText(String resultText) {
                // Set the result text to the appropriate TextView
                hasilTextView.setText(resultText);
            }
        });

    }
}
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {

    EditText editTextHeight, editTextWeight, editTextAge;
    Button buttonCalculateBMI;
    TextView textViewBMIResult;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextAge = findViewById(R.id.editTextAge);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewBMIResult = findViewById(R.id.textViewBMIResult);
        txtResult = findViewById(R.id.txtResult);


        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user inputs
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                int age = Integer.parseInt(editTextAge.getText().toString());

                // Calculate BMI
                double heightInMeter = height / 100; // Convert height to meters
                double bmi = weight / (heightInMeter * heightInMeter);

                // Display BMI result
                textViewBMIResult.setText(String.format("BMI: %.2f", bmi));
                if (bmi>25){
                    txtResult.setText("You're Overweight!");
                    txtResult.setTextColor(getResources().getColor(R.color.red));
                }
                else if (bmi<18) {
                    txtResult.setText("You're Underweight!");
                    txtResult.setTextColor(getResources().getColor(R.color.yellow));
                }
                else {
                    txtResult.setText("You're Healthy");
                    txtResult.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}

package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText weightEditText, valueEditText;
    private TextView totalValueTextView, totalZakatPayableTextView, totalZakatTextView;
    private RadioGroup typeRadioGroup;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_page);

        weightEditText = findViewById(R.id.editTextWeight);
        valueEditText = findViewById(R.id.editTextValue);

        totalValueTextView = findViewById(R.id.textViewTotalValue);
        totalZakatPayableTextView = findViewById(R.id.textViewTotalZakatPayable);
        totalZakatTextView = findViewById(R.id.textViewTotalZakat);

        typeRadioGroup = findViewById(R.id.radioGroupType);

        calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZakat();
            }
        });
    }

    private void calculateZakat() {
        // Get input values
        double weight = Double.parseDouble(weightEditText.getText().toString());
        String type = getSelectedType();
        double value = Double.parseDouble(valueEditText.getText().toString());

        // Calculate gold weight minus X
        double weightMinusX = (type.equals("keep")) ? (weight - 85) : (weight - 200);

        // Check if weightMinusX is greater than or equal to zero
        if (weightMinusX >= 0) {
            // Calculate total value of the gold
            double totalValue = weight * value;

            // Calculate total gold value that is zakat payable
            double totalZakatPayable = weightMinusX * value;

            // Calculate total zakat
            double totalZakat = 0.025 * totalZakatPayable;

            // Update TextViews with results
            totalValueTextView.setText("Total Value: RM " + totalValue);
            totalZakatPayableTextView.setText("Total Zakat Payable: RM " + totalZakatPayable);
            totalZakatTextView.setText("Total Zakat: RM " + totalZakat);
        } else {
            // If weightMinusX is less than zero, display error message
            totalValueTextView.setText("Invalid input. Weight must be greater than X.");
            totalZakatPayableTextView.setText("");
            totalZakatTextView.setText("");
        }
    }

    private String getSelectedType() {
        int selectedRadioButtonId = typeRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId == R.id.radioButtonKeep) {
            return "keep";
        } else if (selectedRadioButtonId == R.id.radioButtonWear) {
            return "wear";
        } else {
            return ""; // Handle the case when no radio button is selected
        }
    }
}

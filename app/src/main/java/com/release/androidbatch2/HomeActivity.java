package com.release.androidbatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText currency, result;
    Button button;
    double dollar, rupee;
    double curencyValue = 0.0;
    int type;
    String currencyType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        type = getIntent().getIntExtra("type", 0);

        switch (type) {
            case 0:
                curencyValue = 74.19;
                currencyType = "Rupee";
                break;
            case 1:
                curencyValue = 103.18;
                currencyType = "Rupee";

                break;
            case 2:
                curencyValue = 1.39;
                currencyType = "Dollar";

                break;
            default:
                curencyValue = 74.19;
                currencyType = "Rupee";

                break;

        }


        currency = findViewById(R.id.curency);
        result = findViewById(R.id.result);
        button = findViewById(R.id.button);


        //Logic
//        1.take the data from edittext once button is pressed --DONE
//        2.calcultae the result (ruppe) .
//        3.display the ruppe in result editetxr


        currency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (currency.getText().toString() != null && !currency.getText().toString().equals("")) {
                    dollar = Double.parseDouble(currency.getText().toString());
                    calculate(dollar);

                } else {
                    rupee = 0.0;
                    result.setText(String.valueOf(rupee));
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currency.getText().toString() != null && !currency.getText().toString().equals("")) {
                    dollar = Double.parseDouble(currency.getText().toString());
                    calculate(dollar);

                } else {
                    Toast.makeText(HomeActivity.this, "Enter a Value!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    private void calculate(double value) {

        rupee = value * curencyValue;

        result.setText(rupee + currencyType);


    }
}
package com.release.androidbatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class RegisterActivity extends AppCompatActivity {

    private EditText email , phone , name , password;
    private Button button;
    AwesomeValidation awesomeValidation ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.emailID);
        phone = findViewById(R.id.phoneNumber);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        button = findViewById(R.id.btn);

        awesomeValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
        awesomeValidation.setContext(this);


        awesomeValidation.addValidation(email, Patterns.EMAIL_ADDRESS,"Enter Valid Email");
        awesomeValidation.addValidation(phone, "^[+]?[0-9]{10,13}$","Enter Valid Phone");
        awesomeValidation.addValidation(password,  ".{8,}","Password Must be greater than 8 chars.");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                validation();
                validationAwesome();
            }
        });


    }

    private void validationAwesome() {
        if (!awesomeValidation.validate()){
            Toast.makeText(this, "Enter the email! ", Toast.LENGTH_SHORT).show();

        }else{
//            email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ticlk, 0);

        }
    }

    //STEP 1: we will be using the toast for the showing error!!
    //TRIM() => this will remove all white spaces
//    white spaces == space before or after the string

    private void validation() {

        if (TextUtils.isEmpty(email.getText().toString().trim())){
            Toast.makeText(this, "Enter the email! ", Toast.LENGTH_SHORT).show();
            email.setError("Enter Valid Email");
            return;
        }else{
            email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.converter, 0);

        }

         if (TextUtils.isEmpty(phone.getText().toString().trim())){
            Toast.makeText(this, "Enter the phone number! ", Toast.LENGTH_SHORT).show();
             phone.setError("Enter Valid Phone");
            return;
        }

         if (TextUtils.isEmpty(name.getText().toString().trim())){
            Toast.makeText(this, "Enter the name! ", Toast.LENGTH_SHORT).show();
             name.setError("Enter Valid Name");
            return;
        }

         if (TextUtils.isEmpty(password.getText().toString().trim())){
            Toast.makeText(this, "Enter the password! ", Toast.LENGTH_SHORT).show();
             password.setError("Enter Valid Password");
            return;
        }

        startActivity(new Intent(RegisterActivity.this, MainActivity.class ));





    }
}
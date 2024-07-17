package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalizedfitnessapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String name = binding.loginUserName.getText().toString();
                String pass = binding.loginPassword.getText().toString();

                if(name.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                else{

                    boolean checkValidation = databaseHelper.checkNameAndPass(pass, name);

                    if(checkValidation){
                        Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Validation", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.registerAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        binding.CancelLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, splashScreen.class);
                startActivity(intent);
            }
        });
    }
}
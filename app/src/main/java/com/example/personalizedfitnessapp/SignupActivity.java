package com.example.personalizedfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalizedfitnessapp.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String username  = binding.signupUserName.getText().toString();
                String email     = binding.signupEmail.getText().toString();
                String password  = binding.signupPassword.getText().toString();
                String cPassword = binding.repassword.getText().toString();


                if(username.equals("") || email.equals("") || password.equals("") || cPassword.equals(""))
                    Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(cPassword)){
                        boolean checkUserEmail = databaseHelper.checkUserEmail(email);

                        if(!checkUserEmail){
                            boolean insert = databaseHelper.insertData(username, email, password);

                            if(insert){
                                Toast.makeText(SignupActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            }else{
                                Toast.makeText(SignupActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        binding.CancelSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}




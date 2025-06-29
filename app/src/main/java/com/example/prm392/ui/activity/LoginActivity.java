package com.example.prm392.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;
    private CheckBox cbRememberMe;
    private Button btnSignIn, btnGoogle;
    private TextView tvForgotPassword, tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.prm392.R.layout.activity_login);

        // Initialize views
        initViews();

        // Set click listeners
        setClickListeners();
    }

    private void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnGoogle = findViewById(R.id.btnGoogle);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignUp = findViewById(R.id.tvSignUp);
    }

    private void setClickListeners() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignIn();
            }
        });


        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGoogleLogin();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });
    }

    private void handleSignIn() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (!isValidEmail(email)) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        }

        // Perform login logic here
        Toast.makeText(this, "Signing in...", Toast.LENGTH_SHORT).show();

        // Example: Save remember me preference
        if (cbRememberMe.isChecked()) {
            // Save login credentials or token
            Toast.makeText(this, "Remember me enabled", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleAppleLogin() {
        Toast.makeText(this, "Continue with Apple clicked", Toast.LENGTH_SHORT).show();
        // Implement Apple Sign-In logic here
    }

    private void handleGoogleLogin() {
        Toast.makeText(this, "Continue with Google clicked", Toast.LENGTH_SHORT).show();
        // Implement Google Sign-In logic here
    }

    private void handleForgotPassword() {
        Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
        // Navigate to forgot password screen
    }

    private void handleSignUp() {
        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show();
        // Navigate to sign up screen
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
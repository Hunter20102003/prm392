package com.example.prm392.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392.R;
import com.example.prm392.activity.MainActivity;
import com.example.prm392.dao.UserDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.User;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;
    private CheckBox cbRememberMe;
    private Button btnSignIn, btnGoogle;
    private TextView tvForgotPassword, tvSignUp;
    private TextView tvError;

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
        tvError = findViewById(R.id.tvError);
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
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        UserDAO dao = db.userDao();
        User user = dao.login(email, password);
        if(user != null) {
            SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("user_role", user.getRole().toString());
            editor.putBoolean("isLoggedIn", true);
            editor.apply();
            tvError.setVisibility(View.GONE);
//            Toast.makeText(this, user.getRole().toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("userId", user.getUserId());
            startActivity(intent);
            finish();
        }else{
            tvError.setText("Invalid Email or Password");
            tvError.setVisibility(View.VISIBLE);
        }


        // Example: Save remember me preference
        if (cbRememberMe.isChecked()) {
            // Save login credentials or token
            Toast.makeText(this, "Remember me enabled", Toast.LENGTH_SHORT).show();
        }
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
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
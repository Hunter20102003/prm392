package com.example.prm392.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392.R;
import com.example.prm392.activity.MainActivity;
import com.example.prm392.dao.UserDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.User;

import java.time.LocalDateTime;

public class SignUpActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPassword, etConfirmPassword, etAddress, etAge;
    private CheckBox cbTerms;
    private Button btnSignUp, btnGoogle, btnFacebook;
    private TextView tvSignIn;
    private ImageView ivPasswordToggle, ivConfirmPasswordToggle;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        userDAO = AppDatabase.getInstance(this).userDao();

        setupListeners();
    }

    private void initViews() {
        etFullName = findViewById(R.id.et_full_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        etAddress = findViewById(R.id.et_address);
        etAge = findViewById(R.id.et_age);
//        cbTerms = findViewById(R.id.cb_terms);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnGoogle = findViewById(R.id.btn_google);
//        btnFacebook = findViewById(R.id.btn_facebook);
        tvSignIn = findViewById(R.id.tv_sign_in);
        ivPasswordToggle = findViewById(R.id.iv_password_toggle);
        ivConfirmPasswordToggle = findViewById(R.id.iv_confirm_password_toggle);
    }

    private void setupListeners() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Google sign up
                Toast.makeText(SignUpActivity.this, "Google Sign Up", Toast.LENGTH_SHORT).show();
            }
        });


        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(SignUpActivity.this, LoginActivity.class) );
                finish(); // or start sign in activity
            }
        });

        ivPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

        ivConfirmPasswordToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleConfirmPasswordVisibility();
            }
        });
    }

    private void handleSignUp() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String ageStr = etAge.getText().toString().trim();

        // Validation
        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            etPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setError("Please confirm your password");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(address)) {
            etAddress.setError("Address is required");
            etAddress.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(ageStr)) {
            etAge.setError("Age is required");
            etAge.requestFocus();
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 1 || age > 120) {
                etAge.setError("Please enter a valid age");
                etAge.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            etAge.setError("Please enter a valid age");
            etAge.requestFocus();
            return;
        }

//        if (!cbTerms.isChecked()) {
//            Toast.makeText(this, "Please agree to the Terms of Service and Privacy Policy", Toast.LENGTH_LONG).show();
//            return;
//        }

        // If all validations pass, proceed with sign up
        performSignUp(fullName, email, password, address, age);
    }

    private void performSignUp(String fullName, String email, String password, String address, int age) {
        // Kiểm tra email đã tồn tại chưa
        User existingUser = userDAO.getUserByEmail(email);
        if (existingUser != null) {
            Toast.makeText(this, "Email đã được sử dụng!", Toast.LENGTH_LONG).show();
            return;
        }

        // Tạo User mới
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Lưu ý: bạn nên mã hoá mật khẩu thực tế
        user.setFullName(fullName);
        user.setPhone(null); // nếu có field này
        user.setImageUrl(null); // nếu có
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userDAO.insertUser(user);

        Toast.makeText(this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
        finish(); // hoặc startActivity(new Intent(this, MainActivity.class));
    }


    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivPasswordToggle.setImageResource(R.drawable.ic_visibility_toggle);
            isPasswordVisible = false;
        } else {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            ivPasswordToggle.setImageResource(R.drawable.ic_visibility_toggle);
            isPasswordVisible = true;
        }
        etPassword.setSelection(etPassword.getText().length());
    }

    private void toggleConfirmPasswordVisibility() {
        if (isConfirmPasswordVisible) {
            etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivConfirmPasswordToggle.setImageResource(R.drawable.ic_visibility_toggle);
            isConfirmPasswordVisible = false;
        } else {
            etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            ivConfirmPasswordToggle.setImageResource(R.drawable.ic_visibility_toggle);
            isConfirmPasswordVisible = true;
        }
        etConfirmPassword.setSelection(etConfirmPassword.getText().length());
    }
}

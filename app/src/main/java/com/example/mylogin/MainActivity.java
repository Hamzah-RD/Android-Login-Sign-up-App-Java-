package com.example.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginButton;
    private CheckBox rememberMeCheckbox;
    private TextView forgotPasswordText;
    private TextView orText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        rememberMeCheckbox = findViewById(R.id.rememberMeCheckbox);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        orText = findViewById(R.id.orText);


        loginButton.setOnClickListener(v -> attemptLogin());

        forgotPasswordText.setOnClickListener(v -> {
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show();

        });
    }

    private void attemptLogin() {
        // Reset errors
        emailInput.setError(null);
        passwordInput.setError(null);


        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        boolean rememberMe = rememberMeCheckbox.isChecked();

        boolean hasError = false;
        View focusView = null;


        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            focusView = passwordInput;
            hasError = true;
        } else if (password.length() < 6) {
            passwordInput.setError("Password must be at least 6 characters");
            focusView = passwordInput;
            hasError = true;
        }


        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            focusView = emailInput;
            hasError = true;
        } else if (!isValidEmail(email)) {
            emailInput.setError("Invalid email format");
            focusView = emailInput;
            hasError = true;
        }

        if (hasError) {

            focusView.requestFocus();
        } else {

            processLogin(email, password, rememberMe);
        }
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void processLogin(String email, String password, boolean rememberMe) {


        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();


        if (rememberMe) {

        }


        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
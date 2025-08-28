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

public class Sign_up extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput, confirmPasswordInput;
    private CheckBox termsCheckbox;
    private Button signupButton;
    private TextView loginText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_sign_up);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        termsCheckbox = findViewById(R.id.termsCheckbox);
        signupButton = findViewById(R.id.signupButton);
        loginText = findViewById(R.id.loginText);



        signupButton.setOnClickListener(v -> attemptSignUp());
        loginText.setOnClickListener(v -> {
            startActivity(new Intent(Sign_up.this, MainActivity.class));
            finish();
        });
    }

    private void attemptSignUp() {

        nameInput.setError(null);
        emailInput.setError(null);
        passwordInput.setError(null);
        confirmPasswordInput.setError(null);


        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String confirmPassword = confirmPasswordInput.getText().toString().trim();
        boolean termsAccepted = termsCheckbox.isChecked();

        boolean hasError = false;
        View focusView = null;


        if (TextUtils.isEmpty(name)) {
            nameInput.setError("Name is required");
            focusView = nameInput;
            hasError = true;
        }


        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            if (focusView == null)
                focusView = emailInput;
            hasError = true;
        } else if (!isValidEmail(email)) {
            emailInput.setError("Invalid email format");
            if (focusView == null) focusView = emailInput;
            hasError = true;
        }


        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            if (focusView == null) focusView = passwordInput;
            hasError = true;
        } else if (password.length() < 6) {
            passwordInput.setError("Password must be at least 6 characters");
            if (focusView == null) focusView = passwordInput;
            hasError = true;
        }


        if (TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordInput.setError("Please confirm your password");
            if (focusView == null) focusView = confirmPasswordInput;
            hasError = true;
        } else if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Passwords don't match");
            if (focusView == null) focusView = confirmPasswordInput;
            hasError = true;
        }


        if (!termsAccepted) {
            Toast.makeText(this, "You must accept terms and conditions", Toast.LENGTH_SHORT).show();
            hasError = true;
        }

        if (hasError) {

            if (focusView != null) focusView.requestFocus();
        } else {

            processSignUp(name, email, password);
        }
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void processSignUp(String name, String email, String password) {

        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();


        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
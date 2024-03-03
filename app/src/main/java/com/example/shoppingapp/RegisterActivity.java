package com.example.shoppingapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, phoneEditText;
    private Button registerButton;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        preferenceManager = new PreferenceManager(this);

        usernameEditText = findViewById(R.id.registerUsername);
        passwordEditText = findViewById(R.id.registerPassword);
        phoneEditText = findViewById(R.id.registerPhone);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        String phone = phoneEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            return;
        }

        if (preferenceManager.isUserExist(username)) {
            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
        } else {
            preferenceManager.setUser(username, password);
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}

package com.example.kolory_egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView emailTextView;
    private EditText emailEditText;

    private TextView passwordTextView;

    private EditText passwordEditText;

    private TextView repPasswordTextView;

    private EditText repPasswordEditText;

    private Button registerBtn;

    private TextView welcomeTextView;

    private String email;
    private String password;
    private String repeatedPassword;


    boolean validatePassword() {
        if (!password.equals(repeatedPassword)) {
            return false;
        }
        return true;
    }

    boolean validateEmail() {
        if (!email.contains("@")) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailTextView = findViewById(R.id.emailTextView);
        emailEditText = findViewById(R.id.emailEditText);
        passwordTextView = findViewById(R.id.passwordTextView);
        passwordEditText = findViewById(R.id.passwordEditText);
        repPasswordTextView = findViewById(R.id.repPasswordTextView);
        repPasswordEditText = findViewById(R.id.repPasswordEditText);
        registerBtn = findViewById(R.id.registerBtn);
        welcomeTextView = findViewById(R.id.welcomeTextView);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();
                repeatedPassword = repPasswordEditText.getText().toString();

                if (!validateEmail()) {
                    welcomeTextView.setText("Nieprawidlowy adres email!");
                    return;
                }
                if (!validatePassword()) {
                    welcomeTextView.setText("Hasla roznia sie!");
                    return;
                }

                welcomeTextView.setText("Witaj " + email);



            }
        });

    }
}
package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextSurname;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String confirm = editTextConfirmPassword.getText().toString().trim();

                // Walidacja danych
                if ( name.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if ( surname.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (phone.length() < 9) {
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Wprowadź dłuższe hasło            (Minimum 6 znaków)", Toast.LENGTH_SHORT).show();
                } else if (!(password.matches(confirm))) {
                    Toast.makeText(MainActivity.this, "Hasła są różne!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}

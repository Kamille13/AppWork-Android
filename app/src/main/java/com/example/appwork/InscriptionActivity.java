package com.example.appwork;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Button btIInscription = findViewById(R.id.btInscription);

        btIInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etFirstName = findViewById(R.id.etFirstName);
                EditText etLastName = findViewById(R.id.etLastName);
                EditText etIemail = findViewById(R.id.etEmail);
                EditText etIpassword = findViewById(R.id.etPassword);


                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String email = etIemail.getText().toString();
                String password = etIpassword.getText().toString();
                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
                    new AlertDialog.Builder(InscriptionActivity.this)
                            .setTitle("Erreur")
                            .setMessage("Veuillez renseigner tout les champs")
                            .show();
                }else{
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setPassword(password);

                    VolleySingleton.getInstance(InscriptionActivity.this).postUser(user, new Consumer<User>() {
                        @Override
                        public void accept(User user) {
                            UserSingleton.getInstance().setUser(user);
                            Intent intent = new Intent(InscriptionActivity.this, ModificationActivity.class);
                            startActivity(intent);
                        }
                    });
                }

            }
        });


    }
}

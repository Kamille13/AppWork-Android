package com.example.appwork;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.util.Consumer;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         Button btConnect = findViewById(R.id.button);
         Button btInscription = findViewById(R.id.button2);

        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = findViewById(R.id.editText);
                EditText etPassword = findViewById(R.id.editText2);
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Erreur")
                            .setMessage("Veuillez renseigner votre email et mot de passe")
                            .show();
                }else{
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    VolleySingleton.getInstance(MainActivity.this).signIn(user, new Consumer<User>() {
                        @Override
                        public void accept(User user) {
                            if(user != null){
                                UserSingleton userSingleton = UserSingleton.getInstance();
                                userSingleton.setUser(user);
                                Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
        btInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}

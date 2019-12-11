package com.example.appwork;

import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);

        Button btModif = findViewById(R.id.btModif);

        btModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = UserSingleton.getInstance().getUser();
                EditText etMfirstName = findViewById(R.id.etModifFirstName);
                String etmfn = etMfirstName.getText().toString();
                EditText etMlastName = findViewById(R.id.etModifLastName);
                String etmln = etMlastName.getText().toString();
                EditText etMemail = findViewById(R.id.etModifEmail);
                String etme = etMemail.getText().toString();
                EditText etMpassWord = findViewById(R.id.etModifPassWord);
                String etmp = etMpassWord.getText().toString();
                if(!etmfn.isEmpty()){
                    user.setFirstName(etmfn);
                }
                if(!etmln.isEmpty()){
                    user.setLastName(etmln);
                }
                if(!etme.isEmpty()){
                    user.setEmail(etme);
                }
                if(!etmp.isEmpty()){
                    user.setPassword(etmp);
                }
                VolleySingleton.getInstance(ModificationActivity.this).updateUser(user.getId(), user.getApiKey(),user, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        Intent intent = new Intent(ModificationActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });



    }


}

package com.example.nishant.ngo.AccountPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nishant.ngo.R;

public class Login extends AppCompatActivity {

    EditText getemail,getpassword;
    Button buttonlogin;
    String s1="Admin",s2="Admin";
    String temps1,temps2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getemail=(EditText)findViewById(R.id.loginemail);

        getpassword=(EditText)findViewById(R.id.loginpassword);

        buttonlogin = (Button)findViewById(R.id.loginbutton);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temps1=getemail.getText().toString().trim();
                temps2=getpassword.getText().toString().trim();

                if((s1.equals(temps1)) && (s2.equals(temps2)) )
                {
                    Intent i = new Intent(Login.this, AdminPanel.class);
                    startActivity(i);
                }
            }
        });
    }
}

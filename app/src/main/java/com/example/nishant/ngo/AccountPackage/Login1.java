package com.example.nishant.ngo.AccountPackage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nishant.ngo.MainActivity;
import com.example.nishant.ngo.R;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login1 extends AppCompatActivity  {

    EditText getemail,getpassword;
    Button buttonlogin;
    String s1="Admin",s2="Admin";
    String temps1,temps2;

    FirebaseAuth auth;
    ProgressDialog progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);






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
                    Intent i = new Intent(Login1.this, AdminPanel1.class);
                    startActivity(i);
                }
                else
                {
                   // signin();
                }
            }
        });


    }
    void signin()
    {
        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(temps1,temps2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if(task.isSuccessful()){
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }
                });


    }


}

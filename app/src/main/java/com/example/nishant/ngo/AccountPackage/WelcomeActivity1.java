package com.example.nishant.ngo.AccountPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nishant.ngo.MainActivity;
import com.example.nishant.ngo.R;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity1 extends AppCompatActivity {

    Button btnlogout;
    FirebaseAuth firebaseAuth;
    TextView cname;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        cname=(TextView)findViewById(R.id.welcomeusername);
        btnlogout=(Button)findViewById(R.id.btnlogout);
/*

        firebaseAuth = FirebaseAuth.getInstance();


        name=firebaseAuth.getCurrentUser().getDisplayName().toString();

        cname.setText(name);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                    //starting login activity
                    Intent i = new Intent(WelcomeActivity1.this,MainActivity.class);
                    startActivity(i);
                }

        });
*/

    }
}

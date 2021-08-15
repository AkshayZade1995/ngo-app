package com.example.nishant.ngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultingActivity extends AppCompatActivity {

    EditText eemailsentto,eemailsubject,eemailmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        eemailsentto = findViewById(R.id.emailsentto);
        eemailsubject = findViewById(R.id.emailsubject);
        eemailmessage = findViewById(R.id.emailmessage);

        Button buttonSend = findViewById(R.id.button_sendemail);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        }

        private void sendMail() {
            String recipientList = eemailsentto.getText().toString();
            String[] recipients = recipientList.split(",");

            String subject = eemailsubject.getText().toString();
            String message = eemailmessage.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        }
    }


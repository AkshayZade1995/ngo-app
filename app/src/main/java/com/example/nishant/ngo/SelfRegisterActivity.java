package com.example.nishant.ngo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SelfRegisterActivity extends AppCompatActivity {

    LinearLayout terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfregister);

        terms =(LinearLayout)findViewById(R.id.termsnconditions);

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        TermsNCondition termsDialog = new TermsNCondition();
        termsDialog.show(getSupportFragmentManager(),"TERMS");
    }
}

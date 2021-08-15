package com.example.nishant.ngo.AccountPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nishant.ngo.AdminCampaigns.AdminCampaignsUpload;
import com.example.nishant.ngo.R;

public class AdminPanel1 extends AppCompatActivity {

    Button CRUDcampaigns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        CRUDcampaigns=(Button)findViewById(R.id.CRUDcampaigns);

        CRUDcampaigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminPanel1.this, AdminCampaignsUpload.class);
                startActivity(i);
            }
        });
    }
}

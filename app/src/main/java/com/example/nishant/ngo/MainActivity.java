package com.example.nishant.ngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.nishant.ngo.AccountPackage.ProfileActivity;
import com.example.nishant.ngo.AccountPackage.ProfileActivity1;
import com.example.nishant.ngo.Achievment.AchievementPieChart;
import com.example.nishant.ngo.AdminCampaigns.CampaignsViewer;
import com.example.nishant.ngo.GoGreen.GoGreenActivity;
import com.example.nishant.ngo.News.NewsMainActivity;
import com.example.nishant.ngo.Volunteer.SelfVolunteeringActivity;

public class MainActivity extends AppCompatActivity {

    CardView profile;
    CardView selfVolunteering;
    CardView goGreen;
    CardView consulting;
    CardView donation;
    CardView ourServices;
    CardView sponsers;
    CardView admincampaigns;
    CardView contactus;

    CardView achievement;

    CardView news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news=(CardView)findViewById(R.id.card11);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsi=new Intent(MainActivity.this, NewsMainActivity.class);
                startActivity(newsi);
            }
        });

        admincampaigns=(CardView)findViewById(R.id.card02);

        achievement=(CardView)findViewById(R.id.card21);

        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAdminCampaignsUpload = new Intent(MainActivity.this,AchievementPieChart.class);
                startActivity(openAdminCampaignsUpload);
            }
        });


        admincampaigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAdminCampaignsUpload = new Intent(MainActivity.this,CampaignsViewer.class);
                startActivity(openAdminCampaignsUpload);
            }
        });

        profile=(CardView)findViewById(R.id.card01);

        contactus = (CardView)findViewById(R.id.card12);

        sponsers=(CardView)findViewById(R.id.card41);

        selfVolunteering=(CardView)findViewById(R.id.card22);

        goGreen=(CardView)findViewById(R.id.card32);

        consulting=(CardView)findViewById(R.id.card21);

        ourServices=(CardView)findViewById(R.id.card42);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*FirebaseAuth auth= FirebaseAuth.getInstance();
               FirebaseUser firebaseUser=auth.getCurrentUser();

               if(firebaseUser!=null)
                {
                    Intent pro = new Intent(MainActivity.this,WelcomeActivity1.class);
                    startActivity(pro);
                }
                else
                {*/
                    Intent proA = new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(proA);

                //}

            }
        });


        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactintent = new Intent(MainActivity.this,ConsultingActivity.class);
                startActivity(contactintent);
            }
        });



        sponsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sponserintent = new Intent(MainActivity.this,SponserActivity.class);
                startActivity(sponserintent);
            }
        });

        selfVolunteering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selfVolunteeringintent = new Intent(MainActivity.this,SelfVolunteeringActivity.class);
                startActivity(selfVolunteeringintent);

            }
        });

        goGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goGreenintent = new Intent(MainActivity.this,GoGreenActivity.class);
                startActivity(goGreenintent);

            }
        });



        donation=(CardView)findViewById(R.id.card31);

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donate = new Intent(MainActivity.this,DonationActivity.class);
                startActivity(donate);
            }
        });

        ourServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ourserviceintent= new Intent(MainActivity.this,ourServiceActivity.class);
                startActivity(ourserviceintent);
            }
        });
    }
}

package com.example.nishant.ngo;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ourServiceActivity extends AppCompatActivity {


    ViewPager viewPager;
    AdapterOurService adapter;
    List<ModelOurService> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_service);


        models = new ArrayList<>();
        models.add(new ModelOurService(R.drawable.ourserviceimg1,"Child Protection","Hello1"));
        models.add(new ModelOurService(R.drawable.ourserviceimg2,"Education","Hello2"));
        models.add(new ModelOurService(R.drawable.ourserviceimg3,"Health and Nutrition","Hello3"));
        models.add(new ModelOurService(R.drawable.ourserviceimg4,"Adoption","Hello4"));

        adapter = new AdapterOurService(models,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)

        };

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1) && position < (colors.length - 1))
                {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position],colors[position + 1]));

                }
                else
                {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}

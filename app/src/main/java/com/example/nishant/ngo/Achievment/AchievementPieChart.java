package com.example.nishant.ngo.Achievment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nishant.ngo.R;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.callback.OnPieSelectListener;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import static com.razerdp.widget.animatedpieview.AnimatedPieViewConfig.FOCUS_WITH_ALPHA_REV;

public class AchievementPieChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_pie_chart);

        AnimatedPieView mAnimatedPieView = findViewById(R.id.achievementpiechartid);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();

        config.addData(new SimplePieInfo(500, Color.parseColor("#E93E58"), "Education"));
        config.addData(new SimplePieInfo(200, Color.parseColor("#44899A"), "Child Protection"));
        config.addData(new SimplePieInfo(140, Color.parseColor("#779B9A"), "Adoption"));
        config.addData(new SimplePieInfo(1000, Color.parseColor("#A4A698"), "Tree Plantation"));
        config.addData(new SimplePieInfo(10, Color.parseColor("#AB6127"), "Events"));
        config.duration(1000);
        config.drawText(true);
        config.strokeMode(true);
        config.textSize(28);
        config.setOnPieSelectListener(new OnPieSelectListener<IPieInfo>() {
            @Override
            public void onSelectPie(@NonNull IPieInfo pieInfo, boolean isFloatUp) {
                Toast.makeText(AchievementPieChart.this, pieInfo.getDesc()+ " " + pieInfo.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
        config.startAngle(-90);
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();

        //drawpie();
    }


}

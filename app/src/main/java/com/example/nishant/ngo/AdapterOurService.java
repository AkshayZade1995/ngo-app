package com.example.nishant.ngo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nishant on 3/25/2019.
 */

public class AdapterOurService extends PagerAdapter {

    private List<ModelOurService> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterOurService(List<ModelOurService> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.itemservice,container,false);

        ImageView imageView;
        TextView title,desc;

        imageView=view.findViewById(R.id.imageOurService);
        title=view.findViewById(R.id.titleOurService);
        desc = view.findViewById(R.id.descOurService);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

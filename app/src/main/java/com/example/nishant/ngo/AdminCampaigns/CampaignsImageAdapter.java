package com.example.nishant.ngo.AdminCampaigns;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nishant.ngo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nishant on 4/14/2019.
 */

public class CampaignsImageAdapter extends RecyclerView.Adapter<CampaignsImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<CampaignsUpload> mUploads;

    public CampaignsImageAdapter(Context context, List<CampaignsUpload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.campaignsimage_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        CampaignsUpload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        holder.textViewNameDescription.setText(uploadCurrent.getDescp());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewNameDescription;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewNameDescription= itemView.findViewById(R.id.text_view_namedescription);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }
}

package com.example.nishant.ngo.AdminCampaigns;

/**
 * Created by Nishant on 4/14/2019.
 */

public class CampaignsUpload {
    private String mName;
    private String mNameDescription;
    private String mImageUrl;

    public CampaignsUpload() {
        //empty constructor needed
    }

    public CampaignsUpload(String name,String description, String imageUrl) {
        if ((name.trim().equals("")) || (description.trim().equals(""))   ) {
            name = "No Name";
            description = "No Name";
        }

        mName = name;
        mNameDescription=description;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;

    }

    public void setName(String name) {
        mName = name;

    }

    public String getDescp() {
        return mNameDescription;

    }


    public void setDescp(String Description) {
        mNameDescription = Description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}

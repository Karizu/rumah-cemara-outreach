package com.boardinglabs.rumahcemara.outreach.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.boardinglabs.rumahcemara.outreach.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ListClientHolder extends RecyclerView.ViewHolder {

    public CircularImageView imgUrl;
    public TextView name;
    public TextView phoneNumber;

    public ListClientHolder(View itemView) {
        super(itemView);
        imgUrl = itemView.findViewById(R.id.imgListProfile);
        name = (TextView) itemView.findViewById(R.id.tvName);
        phoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
    }
}

package com.boardinglabs.rumahcemara.outreach.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.DetailListClientActivity;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.models.ClientModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class AdapterListClient extends RecyclerView.Adapter<AdapterListClient.ViewHolder> {
    private List<ClientModel> articleModels;
    private Context context;

    public AdapterListClient(List<ClientModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterListClient.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_fragment_client_tab, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterListClient.ViewHolder holder, int position){
        final ClientModel articleModel = articleModels.get(position);
        final String id = articleModel.getId();
        final String imgUrl = articleModel.getSrcImage();
        final String fullName = articleModel.getFullName();
        final String phoneNumber = articleModel.getPhoneNumber();

        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(articleModel.getSrcImage()).into(holder.imageView);
        holder.textViewFullname.setText(articleModel.getFullName());
        holder.textViewPhoneNumber.setText(articleModel.getPhoneNumber());
        holder.linearLayout.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("imgUrl", imgUrl);
            bundle.putString("fullName", fullName);
            bundle.putString("phoneNumber", phoneNumber);

            Intent in=new Intent(context, DetailListClientActivity.class);
            in.putExtra("myData", bundle);
            context.startActivity(in);
        });
    }

    @Override
    public int getItemCount(){ return articleModels.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CircularImageView imageView;
        public TextView textViewFullname;
        public TextView textViewPhoneNumber;
        public FrameLayout linearLayout;

        public ViewHolder(View v){
            super(v);

            imageView = (CircularImageView) v.findViewById(R.id.imgListProfile);
            textViewFullname = (TextView) v.findViewById(R.id.tvName);
            textViewPhoneNumber = (TextView) v.findViewById(R.id.tvPhoneNumber);
            linearLayout = (FrameLayout) v.findViewById(R.id.layout_article);
        }
    }
}


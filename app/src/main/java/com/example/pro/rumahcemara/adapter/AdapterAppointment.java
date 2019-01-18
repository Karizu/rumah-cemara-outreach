package com.example.pro.rumahcemara.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro.rumahcemara.DetailAppointmentActivity;
import com.example.pro.rumahcemara.R;
import com.example.pro.rumahcemara.models.RequestModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class AdapterAppointment extends RecyclerView.Adapter<AdapterAppointment.ViewHolder> {
    private List<RequestModel> articleModels;
    private Context context;

    public AdapterAppointment(List<RequestModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterAppointment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_fragment_appointment_tab, parent, false);

        return new AdapterAppointment.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterAppointment.ViewHolder holder, int position){
        final RequestModel articleModel = articleModels.get(position);
        final String serviceId = articleModel.getServiceId();
        final String serviceName = articleModel.getServiceName();
        final String imgUrl = articleModel.getImgUrl();
        final String fullName = articleModel.getFullName();
        final String phoneNumber = articleModel.getPhoneNumber();
        final String startDate = articleModel.getStart_date();
        final String endDate = articleModel.getEnd_date();
        final String description = articleModel.getDescription();
        final String location = articleModel.getLocation();

        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(articleModel.getImgUrl()).into(holder.imageView);
        holder.textViewFullname.setText(articleModel.getFullName());
        holder.textViewPhoneNumber.setText(articleModel.getPhoneNumber());
        holder.linearLayout.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("serviceId", serviceId);
            bundle.putString("serviceName", serviceName);
            bundle.putString("imgUrl", imgUrl);
            bundle.putString("fullName", fullName);
            bundle.putString("phoneNumber", phoneNumber);
            bundle.putString("startDate", startDate);
            bundle.putString("endDate", endDate);
            bundle.putString("description", description);
            bundle.putString("location", location);

            Intent in=new Intent(context, DetailAppointmentActivity.class);
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

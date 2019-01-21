package com.boardinglabs.rumahcemara.outreach.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.models.DetailClientModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdapterDetailListClient extends RecyclerView.Adapter<AdapterDetailListClient.ViewHolder> {
    private List<DetailClientModel> articleModels;
    private Context context;

    public AdapterDetailListClient(List<DetailClientModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterDetailListClient.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_detail_list_client, parent, false);

        return new AdapterDetailListClient.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterDetailListClient.ViewHolder holder, int position){
        final DetailClientModel articleModel = articleModels.get(position);
        final String serviceId = articleModel.getServiceId();
        final String serviceName = articleModel.getServiceName();
        final String imgUrl = articleModel.getImgUrl();
        final String fullName = articleModel.getFullName();
        final String phoneNumber = articleModel.getPhoneNumber();
        final String startDate = articleModel.getStart_date();
        final String endDate = articleModel.getEnd_date();
        final String description = articleModel.getDescription();
        final String location = articleModel.getLocation();
        final String attachment = articleModel.getAttachment();

        holder.textViewServiceName.setText(serviceName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = sdf.parse(endDate);
            String formated = new SimpleDateFormat("dd MMMM yyyy").format(date);
            holder.textViewUpdatedAt.setText(formated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.textViewLocation.setText(location);
//        holder.linearLayout.setOnClickListener(view -> {
//            Bundle bundle = new Bundle();
//            bundle.putString("serviceId", serviceId);
//            bundle.putString("serviceName", serviceName);
//            bundle.putString("imgUrl", imgUrl);
//            bundle.putString("fullName", fullName);
//            bundle.putString("phoneNumber", phoneNumber);
//            bundle.putString("startDate", startDate);
//            bundle.putString("endDate", endDate);
//            bundle.putString("description", description);
//            bundle.putString("location", location);
//
//            Intent in=new Intent(context, DetailAppointmentActivity.class);
//            in.putExtra("myData", bundle);
//            context.startActivity(in);
//        });
    }

    @Override
    public int getItemCount(){ return articleModels.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewServiceName;
        public TextView textViewUpdatedAt;
        public TextView textViewLocation;
        public FrameLayout linearLayout;

        public ViewHolder(View v){
            super(v);

            textViewServiceName = (TextView) v.findViewById(R.id.tvServiceName);
            textViewUpdatedAt = (TextView) v.findViewById(R.id.tvUpdateAt);
            textViewLocation = v.findViewById(R.id.tvLocation);
            linearLayout = (FrameLayout) v.findViewById(R.id.layout_article);
        }
    }

}

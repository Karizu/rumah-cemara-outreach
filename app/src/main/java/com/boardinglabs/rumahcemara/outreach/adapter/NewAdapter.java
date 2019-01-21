package com.boardinglabs.rumahcemara.outreach.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.Profile;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ListClientAdapter>{

    private List<Profile> dataList;
    private Context context;

    public NewAdapter(Context context,List<Profile> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class ListClientAdapter extends RecyclerView.ViewHolder {

        public final View mView;

        TextView fullname, username, phonenumber, image;
//        private ImageView coverImage;

        ListClientAdapter(View itemView) {
            super(itemView);
            mView = itemView;

            fullname = (TextView) mView.findViewById(R.id.tvName);
            phonenumber = (TextView) mView.findViewById(R.id.tvPhoneNumber);
//            report_time = (TextView) mView.findViewById(R.id.time);
//            coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public ListClientAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.content_fragment_client_tab, parent, false);
        return new ListClientAdapter(view);
    }

    @Override
    public void onBindViewHolder(ListClientAdapter holder, int position) {
        holder.fullname.setText(dataList.get(position).getFullname());
        holder.phonenumber.setText(dataList.get(position).getPhoneNumber());

//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(dataList.get(position).getThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
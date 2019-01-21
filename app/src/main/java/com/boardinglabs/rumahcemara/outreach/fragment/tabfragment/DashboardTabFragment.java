package com.boardinglabs.rumahcemara.outreach.fragment.tabfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.apihelper.API;
import com.boardinglabs.rumahcemara.outreach.apihelper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.Dashboard;
import com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile;
import com.boardinglabs.rumahcemara.outreach.models.RequestModel;
import com.boardinglabs.rumahcemara.outreach.models.Total7Day;
import com.boardinglabs.rumahcemara.outreach.models.Total7DayModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardTabFragment extends Fragment {

    private BarChart mBarChart;
    String[] days;
    GraphView graph;
    private BarGraphSeries<DataPoint> series;
    private TextView dateNow, rangeDate, month, totalRange, totalMonth;
    private Date d1, d2, d3, d4, d5, d6, d7;
    private final static String TAG = DashboardTabFragment.class.getSimpleName();
    private LoadingDialog loadingDialog;
    private List<Total7DayModel> articleModels;
    String sId, sTokenId, sGroupId, sBearerToken,
            sTotal1, sTotal2, sTotal3, sTotal4, sTotal5, sTotal6, sTotal7,
            sTotalRange, sTotal7Day, sTotalMonth, sMonth;
    SessionManagement session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_tab, container, false);

        session = new SessionManagement(getActivity());
        HashMap<String, String> user = session.getUserDetails();
        sId = user.get(SessionManagement.KEY_ID);
        sGroupId = user.get(SessionManagement.KEY_GROUP_ID);
        sTokenId = user.get(SessionManagement.KEY_IMG_TOKEN);
        sBearerToken = "Bearer " + sTokenId;

        loadingDialog = new LoadingDialog(getActivity());

        dateNow = view.findViewById(R.id.tvDateNow);
        rangeDate = view.findViewById(R.id.tvRangeDate);
        month = view.findViewById(R.id.tvMonth);
        totalRange = view.findViewById(R.id.tvTotalRange);
        totalMonth = view.findViewById(R.id.tvTotalMonth);

        DateFormat format = new SimpleDateFormat("dd MMM");
        Calendar calendar = Calendar.getInstance();
//        calendar.setFirstDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
//        calendar.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK));
//        Date d42 = calendar.getTime();
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        Date d52 = calendar.getTime();
//        String d62 = format.format(calendar.getTime());
//        System.out.println("d4: "+d42+" d6 :"+d62);

        // generate Dates
        d1 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d2 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d3 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d4 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d5 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d6 = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        d7 = calendar.getTime();

        System.out.println("d1: " + d1 + "d2 :" + d2 + "d3 :" + d3);

        generateDateNow();

        getProfileDetail();

        getDashboardGraph();

        graph = view.findViewById(R.id.graph);
        series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(d7, 1),
                new DataPoint(d6, 5),
                new DataPoint(d5, 3),
                new DataPoint(d4, 6),
                new DataPoint(d3, 1),
                new DataPoint(d2, 3),
                new DataPoint(d1, 5),
        });

        graph.addSeries(series);

        // set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport().setMinX(d7.getTime());
        graph.getViewport().setMaxX(d1.getTime());
        graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
        graph.getGridLabelRenderer().setHumanRounding(false);
        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.addSeries(series);
//        series.setValueDependentColor(data -> Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100));
        series.setColor(Color.CYAN);

        series.setSpacing(40);

        series.setDataWidth(10);
// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);

        return view;
    }

    private DataPoint[] generateData() {

        DateFormat format = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK));
        DataPoint[] values = new DataPoint[7];
        days = new String[7];
        String input = "26";
        String pattern = "-?\\d+";
        for (int i = 0; i < 7; i++) {
            days[i] = format.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            DataPoint v = new DataPoint(Double.parseDouble(days[i]), 4);
            values[i] = v;
            System.out.println("days: " + days[i]);
        }
        return values;
    }

    public void generateDateNow() {
        DateFormat formatDay = new SimpleDateFormat("EEEE, dd MMM");
        DateFormat formatRangeDate = new SimpleDateFormat("dd MMM");
        DateFormat formatMonth = new SimpleDateFormat("MMMM");
        Calendar datenow = Calendar.getInstance();
        String today = formatDay.format(d1);
        String rangeDateD7 = formatRangeDate.format(d7);
        String rangeDateD1 = formatRangeDate.format(d1);
        String rangeMonth = formatMonth.format(d1);
        switch (rangeMonth) {
            case "Januari":
                sMonth = "1";
                break;
            case "Februari":
                sMonth = "2";
                break;
            case "Maret":
                sMonth = "3";
                break;
            case "April":
                sMonth = "4";
                break;
            case "Mei":
                sMonth = "5";
                break;
            case "Juni":
                sMonth = "6";
                break;
            case "Juli":
                sMonth = "7";
                break;
            case "Agustus":
                sMonth = "8";
                break;
            case "September":
                sMonth = "9";
                break;
            case "Oktober":
                sMonth = "10";
                break;
            case "November":
                sMonth = "11";
                break;
            case "Desember":
                sMonth = "12";
                break;
        }
        dateNow.setText(today);
        rangeDate.setText(rangeDateD7 + " - " + rangeDateD1);
        month.setText(rangeMonth);


    }

    private void getProfileDetail() {
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getDashboardData(sGroupId, sId, sMonth, sBearerToken).enqueue(new Callback<ApiResponse<Dashboard>>() {
            @Override
            public void onResponse(Call<ApiResponse<Dashboard>> call, Response<ApiResponse<Dashboard>> response) {

                loadingDialog.dismiss();
                final ApiResponse<Dashboard> user = response.body();
               // System.out.println("JSON: " + user.getData());
                sTotalRange = user.getData().getTotalRange();
                sTotalMonth = user.getData().getTotalMonth();
//
                totalRange.setText(sTotalRange);
                totalMonth.setText(sTotalMonth);
            }

            @Override
            public void onFailure(Call<ApiResponse<Dashboard>> call, Throwable t) {
                loadingDialog.dismiss();
                Log.e(TAG, t.toString());
                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDashboardGraph() {
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        API.baseApiService().getDashboardGraph(sGroupId, sId, sMonth, sBearerToken).enqueue(new Callback<ApiResponse<List<Total7Day>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Total7Day>>> call, Response<ApiResponse<List<Total7Day>>> response) {

                loadingDialog.dismiss();
                final List<Total7Day> res = response.body().getData();
                articleModels = new ArrayList<>();
                System.out.println("JSON: " + res);
                for (int i = 0; i < res.size(); i++) {
                    Total7Day article = res.get(i);
                    articleModels.add(new Total7DayModel(article.getDate(),
                            article.getTotal()
                    ));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Total7Day>>> call, Throwable t) {
                loadingDialog.dismiss();
                Log.e(TAG, t.toString());
                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

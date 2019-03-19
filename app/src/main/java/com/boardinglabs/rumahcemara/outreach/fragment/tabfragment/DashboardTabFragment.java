package com.boardinglabs.rumahcemara.outreach.fragment.tabfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.helper.API;
import com.boardinglabs.rumahcemara.outreach.helper.ApiResponse;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.dialog.LoadingDialog;
import com.boardinglabs.rumahcemara.outreach.models.Dashboard;
import com.boardinglabs.rumahcemara.outreach.models.Total7DayModel;
import com.github.mikephil.charting.charts.BarChart;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private TextView dateNow, rangeDate, month, totalRange, totalMonth, totalToday;
    private Date d1, d2, d3, d4, d5, d6, d7, dDate;
    private final static String TAG = DashboardTabFragment.class.getSimpleName();
    private LoadingDialog loadingDialog;
    private List<Total7DayModel> articleModels;
    String sId, sTokenId, sGroupId, sBearerToken, paramStartDate, paramEndDate,
            sTotal1, sTotal2, sTotal3, sTotal4, sTotal5, sTotal6, sTotal7, sTotalRange,
            sTotalMonth, sMonth;
    Integer sTotal7Day1, sTotal7Day2, sTotal7Day3, sTotal7Day4, sTotal7Day5, sTotal7Day6, sTotal7Day7;
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
        totalToday = view.findViewById(R.id.tvAppointmentTotal);
        graph = view.findViewById(R.id.graph);

        DateFormat format = new SimpleDateFormat("dd MMM");
        Calendar calendar = Calendar.getInstance();
        Calendar paramDate = Calendar.getInstance();
        paramDate.add(Calendar.DATE, +1);
        dDate = paramDate.getTime();
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

        generateDateNow();

        getProfileDetail();

        return view;
    }

    public void generateDateNow() {
        DateFormat formatDay = new SimpleDateFormat("EEEE, dd MMM");
        DateFormat formatRangeDate = new SimpleDateFormat("dd MMM");
        DateFormat formatMonth = new SimpleDateFormat("MMMM");
        DateFormat formatParamDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar datenow = Calendar.getInstance();
        paramStartDate = formatParamDate.format(d7);
        paramEndDate = formatParamDate.format(dDate);
        String today = formatDay.format(d1);
        String rangeDateD7 = formatRangeDate.format(d7);
        String rangeDateD1 = formatRangeDate.format(d1);
        String rangeMonth = formatMonth.format(d1);
        switch (rangeMonth) {
            case "Januari":
            case "January":
                sMonth = "1";
                break;
            case "Februari":
            case "February":
                sMonth = "2";
                break;
            case "Maret":
            case "March":
                sMonth = "3";
                break;
            case "April":
                sMonth = "4";
                break;
            case "Mei":
            case "May":
                sMonth = "5";
                break;
            case "Juni":
            case "June":
                sMonth = "6";
                break;
            case "Juli":
            case "July":
                sMonth = "7";
                break;
            case "Agustus":
            case "August":
                sMonth = "8";
                break;
            case "September":
                sMonth = "9";
                break;
            case "Oktober":
            case "October":
                sMonth = "10";
                break;
            case "November":
                sMonth = "11";
                break;
            case "Desember":
            case "December":
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
        API.baseApiService().getDashboardData(sGroupId, sId, sMonth, paramStartDate, paramEndDate, sBearerToken).enqueue(new Callback<ApiResponse<Dashboard>>() {
            @Override
            public void onResponse(Call<ApiResponse<Dashboard>> call, Response<ApiResponse<Dashboard>> response) {
                loadingDialog.dismiss();

                if (response.body() != null && response.isSuccessful()){
                    ApiResponse<Dashboard> user = response.body();
//                System.out.println("JSON: " + response.body().toString());
                    sTotalRange = user.getData().getTotalRange();
                    sTotalMonth = user.getData().getTotalMonth();

                    totalRange.setText(sTotalRange);
                    totalMonth.setText(sTotalMonth);

                    String[] total7Date = new String[7];
                    Integer[] total7Count = new Integer[7];
                    for (int i = 0; i < 7; i++) {
                        total7Date[i] = user.getData().getTotal7day().get(i).getDate();
                        total7Count[i] = Integer.valueOf(user.getData().getTotal7day().get(i).getTotal());
                        sTotal7Day1 = total7Count[0];
                        sTotal7Day2 = total7Count[1];
                        sTotal7Day3 = total7Count[2];
                        sTotal7Day4 = total7Count[3];
                        sTotal7Day5 = total7Count[4];
                        sTotal7Day6 = total7Count[5];
                        sTotal7Day7 = total7Count[6];
                    }

                    totalToday.setText(sTotal7Day1 + "x Appointment");

                    series = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(d7, sTotal7Day7),
                            new DataPoint(d6, sTotal7Day6),
                            new DataPoint(d5, sTotal7Day5),
                            new DataPoint(d4, sTotal7Day4),
                            new DataPoint(d3, sTotal7Day3),
                            new DataPoint(d2, sTotal7Day2),
                            new DataPoint(d1, sTotal7Day1),
                    });

                    graph.addSeries(series);

                    // set date label formatter
                    graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(
                            getActivity(),new SimpleDateFormat("dd MMM")));
                    graph.getGridLabelRenderer().setNumHorizontalLabels(7); // only 4 because of the space
                    graph.getGridLabelRenderer().setTextSize(30);

// set manual x bounds to have nice steps
                    graph.getViewport().setMinX(d7.getTime());
                    graph.getViewport().setMaxX(d1.getTime());
                    graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
                    graph.getGridLabelRenderer().setHumanRounding(false, false);
                    // enable scaling and scrolling
                    graph.getViewport().setScalable(true);
                    graph.getViewport().setScalableY(true);

// styling
//                series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
//                    @Override
//                    public int get(DataPoint data) {
//                        return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
//                    }
//                });
                    series.setColor(getResources().getColor(R.color.colorAccent));

                    series.setSpacing(40);

//                series.setDataWidth(10);
// draw values on top
                    series.setDrawValuesOnTop(true);
                    series.setValuesOnTopColor(getResources().getColor(R.color.colorPrimary));
//series.setValuesOnTopSize(50);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Dashboard>> call, Throwable t) {
                loadingDialog.dismiss();
                Log.e(TAG, t.toString());
                Toast.makeText(getActivity(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

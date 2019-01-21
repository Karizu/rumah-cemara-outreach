package com.boardinglabs.rumahcemara.outreach.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boardinglabs.rumahcemara.outreach.HistoryAppointmentActivity;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.AppointmentTabFragment;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.ClientTabFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyListFragment extends Fragment {
    Toolbar mToolbar;
    private int langeuage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_list, container, false);
        ButterKnife.bind(this, view);

        SessionManagement sessionManagement = new SessionManagement(getActivity());
        langeuage = sessionManagement.getLanguage();

        ViewPager viewPager = view.findViewById(R.id.container);
        setupViewPager(viewPager);
        mToolbar = view.findViewById(R.id.toolbar);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        if (langeuage == 0) {
            mToolbar.setTitle("My List");
        } else {
            mToolbar.setTitle("List Saya");
        }

        return view;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        if (langeuage == 0) {
            adapter.addFragment(new AppointmentTabFragment(), "Appointment");
            adapter.addFragment(new ClientTabFragment(), "Client");
        } else {
            adapter.addFragment(new AppointmentTabFragment(), "Appointment");
            adapter.addFragment(new ClientTabFragment(), "Klien");
        }

        viewPager.setAdapter(adapter);

    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @OnClick(R.id.imgHistoryAppointment)
    void onClickHistory(){

        Intent intent = new Intent(getActivity(), HistoryAppointmentActivity.class);
        startActivity(intent);

    }
}

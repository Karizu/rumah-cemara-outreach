package com.boardinglabs.rumahcemara.outreach.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.config.SessionManagement;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.DashboardTabFragment;
import com.boardinglabs.rumahcemara.outreach.fragment.tabfragment.RequestTabFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private int languageId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SessionManagement sessionManagement = new SessionManagement(getActivity());
        languageId = sessionManagement.getLanguage();

        ViewPager viewPager = view.findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());

        if (languageId == 0) {
            adapter.addFragment(new RequestTabFragment(), "Request");
            adapter.addFragment(new DashboardTabFragment(), "Dashboard");
        } else {
            adapter.addFragment(new RequestTabFragment(), "Permintaan");
            adapter.addFragment(new DashboardTabFragment(), "Dashboard");
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
}

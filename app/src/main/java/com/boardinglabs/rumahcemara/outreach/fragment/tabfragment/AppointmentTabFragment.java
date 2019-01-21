package com.boardinglabs.rumahcemara.outreach.fragment.tabfragment;

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

import java.util.ArrayList;
import java.util.List;

public class AppointmentTabFragment extends Fragment {
    private int language;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment_tab, container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = view.findViewById(R.id.container);

        SessionManagement sessionManagement = new SessionManagement(getActivity());
        language = sessionManagement.getLanguage();

        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        return view;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());

        if (language == 0) {
            adapter.addFragment(new BiomedicalTabFragment(), "Biomedical");
            adapter.addFragment(new CounselingTabFragment(), "Counseling");
            adapter.addFragment(new LegalTabFragment(), "Legal Counseling");
        } else {
            adapter.addFragment(new BiomedicalTabFragment(), "Biomedical");
            adapter.addFragment(new CounselingTabFragment(), "Konseling");
            adapter.addFragment(new LegalTabFragment(), "Legal Konseling");
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

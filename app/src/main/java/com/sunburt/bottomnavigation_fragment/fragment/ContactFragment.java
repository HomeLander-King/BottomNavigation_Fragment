package com.sunburt.bottomnavigation_fragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.sunburt.bottomnavigation_fragment.R;

public class ContactFragment extends Fragment {
    private TabLayout tab;
    private ViewPager viewPager;
    private FragmentTabAdapter adapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        tab = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewTab);
        adapter = new FragmentTabAdapter(getChildFragmentManager(),
                FragmentTabAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        tab.getTabAt(0).setIcon(R.drawable.facebook);
        return view;
    }
}
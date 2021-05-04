package com.sunburt.bottomnavigation_fragment.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentTabAdapter extends FragmentStatePagerAdapter {

    int numPage = 3;
    public FragmentTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FaceBookFragment();
            case 1:
                return new GoogleFragment();
            case 2:
                return new TwitterFragment();
            default:
                return new FaceBookFragment();
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Facebook";
            case 1:
                return "Google";
            case 2:
                return "Twitter";
            default: return "Facebook";
        }
    }
}

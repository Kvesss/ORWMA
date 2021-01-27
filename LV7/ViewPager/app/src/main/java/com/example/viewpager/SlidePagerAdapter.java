package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> items;

    private static final int NUM_PAGES = 3;

    public SlidePagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.items = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);

//        switch (position){
//            case 0:
//                return SlideFragment.newInstance("This is fragment #1");
//            case 1:
//                return  SlideFragment.newInstance("This is fragment #2");
//            default:
//                return SlideFragment.newInstance("This is fragment #3");
//        }
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab #" + (position + 1);
    }
}

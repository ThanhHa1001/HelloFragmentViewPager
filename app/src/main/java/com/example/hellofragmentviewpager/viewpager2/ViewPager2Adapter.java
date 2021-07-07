package com.example.hellofragmentviewpager.viewpager2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPager2Adapter extends FragmentStateAdapter {

    private List<FirstFragment> fragmentList;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<FirstFragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public long getItemId(int position) {
        Log.e("ViewPager2Adapter", "getItemId: " + position);
        return fragmentList.get(position).hashCode();
    }

    @Override
    public boolean containsItem(long itemId) {
        return containsItem(itemId);
    }
}

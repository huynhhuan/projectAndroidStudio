package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Tab_msv();
            case 1:
                return new Tab_tensv();
            case 2:
                return new Tab_lopsinhhoat();
            default:
                return new Tab_msv();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

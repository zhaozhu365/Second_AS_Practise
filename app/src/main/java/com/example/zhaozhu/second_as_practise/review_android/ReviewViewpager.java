package com.example.zhaozhu.second_as_practise.review_android;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.zhaozhu.second_as_practise.App;

/**
 * Created by zhaozhu on 17/3/16.
 */

public class ReviewViewPager extends Fragment {

    ViewPager mViewPager = new ViewPager(App.getAppContext());

    {
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);//TODO 还没弄仔细看这俩
        mViewPager.addOnAdapterChangeListener(mOnAdapterChangeListener);//TODO

        mViewPager.setAdapter(new MPagerAdapter());
        mViewPager.setAdapter(new MFragmentAdapter(getChildFragmentManager()));
        mViewPager.setAdapter(new MFragmentStateAdapter(getChildFragmentManager()));

    }

    public static class MPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }

    public static class MFragmentAdapter extends FragmentPagerAdapter {

        public MFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

    public static class MFragmentStateAdapter extends FragmentStatePagerAdapter {

        public MFragmentStateAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

    static ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    static ViewPager.OnAdapterChangeListener mOnAdapterChangeListener = new ViewPager.OnAdapterChangeListener() {
        @Override
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {

        }
    };

}

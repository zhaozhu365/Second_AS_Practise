package com.example.zhaozhu.second_as_practise.review_android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.zhaozhu.second_as_practise.App;

/**
 * Created by zhaozhu on 17/3/10.
 */

public class ReviewListView {

    ListView mListView = new ListView(App.getAppContext());

    {
        View view = new View(App.getAppContext());
        mListView.addHeaderView(view);
        mListView.removeHeaderView(view);
        mListView.getHeaderViewsCount();
        mListView.areHeaderDividersEnabled();

        mListView.addFooterView(view);
        mListView.removeFooterView(view);
        mListView.getFooterViewsCount();
        mListView.areFooterDividersEnabled();

        mListView.setAdapter(new MAdapter());

        //TODO mListView的复用机制

    }

    public static class MAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}

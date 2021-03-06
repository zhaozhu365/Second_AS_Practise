package com.example.zhaozhu.second_as_practise;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhaozhu.second_as_practise.fragment_test_1.Test1Fragment;
import com.example.zhaozhu.second_as_practise.fragment_widgets.WidgetsFragment;
import com.example.zhaozhu.second_as_practise.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 16/11/5.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.main_fragment_content)
    FrameLayout mainFragmentContent;
    @BindView(R.id.main_listview)
    ListView mMainListview;
    List<MBaseFragment> mFragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //添加item
        mFragmentList = new ArrayList<>();

        //TODO start 在此添加测试页面
        mFragmentList.add(new Test1Fragment());//fragment练习
        mFragmentList.add(new WidgetsFragment());//自定义view练习

        //TODO end

        MyAdapter myAdapter = new MyAdapter(getActivity());
        mMainListview.setAdapter(myAdapter);
        myAdapter.setItems(mFragmentList);
    }

    class MyAdapter extends BaseAdapter {

        private Context mContext;
        private List<MBaseFragment> mFragmentList = new ArrayList<>();

        public MyAdapter(Context context) {
            mContext = context;
        }

        public void setItems(List<MBaseFragment> fragmentList) {
            if (fragmentList == null || fragmentList.isEmpty()) {
                return;
            }
            mFragmentList.clear();
            mFragmentList.addAll(fragmentList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            if (mFragmentList == null || mFragmentList.isEmpty()) {
                return 0;
            }
            return mFragmentList.size();
        }

        @Override
        public MBaseFragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.layout_item_textview, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.mTextView.setText((position + 1 + "、") + getItem(position).getFragmentDesc());
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.main_fragment_content, getItem(position));
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return convertView;
        }

        private class ViewHolder {
            public TextView mTextView;
            public ViewHolder(View root) {
                this.mTextView = (TextView) root.findViewById(R.id.layout_item_tv);
            }
        }

    }

}


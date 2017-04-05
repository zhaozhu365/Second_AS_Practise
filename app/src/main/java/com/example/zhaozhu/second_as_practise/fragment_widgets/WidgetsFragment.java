package com.example.zhaozhu.second_as_practise.fragment_widgets;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 17/3/17.
 */

public class WidgetsFragment extends MBaseFragment {

    @BindView(R.id.widgets_lv)
    ListView mListView;
    private MAdapter mAdapter;
    private List<MBaseFragment> mList;

    @Override
    public String getFragmentDesc() {
        return WidgetsFragment.class.getSimpleName() + "：此Fragment用于自定义view的练习~";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_widgets, null);
//        View view = inflater.inflate(R.layout.fragment_widgets, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new MAdapter(getActivity());
        mListView.setAdapter(mAdapter);

        mList = new ArrayList<>();

        //start
        mList.add(new DashLineFragment());
        mList.add(new BubblesFragment());
        mList.add(new CircleProgressBarFragment());
        mList.add(new FlowLayoutFragment());
        //end

        mAdapter.setItems(mList);
    }

    private class MAdapter extends BaseAdapter {

        private List<MBaseFragment> mList = new ArrayList<>();
        private Context mContext;

        public MAdapter(Context context) {
            mContext = context;
        }

        public void setItems(List<MBaseFragment> mItems) {
            if (mItems == null || mItems.isEmpty()) {
                return;
            }
            mList.clear();
            mList.addAll(mItems);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            if (mList == null || mList.isEmpty()) {
                return 0;
            }
            return mList.size();
        }

        @Override
        public MBaseFragment getItem(int position) {
            return mList.get(position);
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
                    transaction.replace(R.id.fragment_widgets_content, getItem(position));
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

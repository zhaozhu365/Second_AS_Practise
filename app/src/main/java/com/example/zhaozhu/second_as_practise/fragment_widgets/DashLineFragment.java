package com.example.zhaozhu.second_as_practise.fragment_widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;
import com.example.zhaozhu.second_as_practise.widgets_prac.DashLineView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 17/3/17.
 */

public class DashLineFragment extends MBaseFragment {
    @Override
    public String getFragmentDesc() {
        return DashLineFragment.class.getSimpleName() + " 竖着的虚线";
    }

    @BindView(R.id.widgets_dashline)
    DashLineView mDashLineView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_widgets_dashline, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDashLineView.setLineColor(Color.RED);
    }
}

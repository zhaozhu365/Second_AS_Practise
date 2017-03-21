package com.example.zhaozhu.second_as_practise.fragment_widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;
import com.example.zhaozhu.second_as_practise.widgets_prac.CircleProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 17/3/17.
 */

public class CircleProgressBarFragment extends MBaseFragment {
    @Override
    public String getFragmentDesc() {
        return CircleProgressBarFragment.class.getSimpleName() + " 圆形进度条";
    }

    @BindView(R.id.widgets_CircleProgressBar)
    CircleProgressBar mCircleProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_widgets_circle_progressbar, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //progress是百分比数,0-100
        mCircleProgressBar.setProgress(30);
    }
}

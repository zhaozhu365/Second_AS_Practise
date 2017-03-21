package com.example.zhaozhu.second_as_practise.fragment_widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;
import com.example.zhaozhu.second_as_practise.widgets_prac.BubbleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 17/3/17.
 */

public class BubblesFragment extends MBaseFragment {
    @Override
    public String getFragmentDesc() {
        return BubblesFragment.class.getSimpleName() + " 气泡";
    }

    @BindView(R.id.widgets_bubble)
    BubbleView mBubbleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_widgets_bubbles, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bubble.setCircleColors(R.color.color_fecf05, R.color.color_fee36c);
        mBubbleView.setColors(getResources().getColor(R.color.color_main), Color.RED);
    }
}

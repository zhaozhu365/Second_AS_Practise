package com.example.zhaozhu.second_as_practise.fragment_widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;

import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 17/4/5.
 */

public class FlowLayoutFragment extends MBaseFragment {
    @Override
    public String getFragmentDesc() {
        return FlowLayoutFragment.class.getSimpleName() + " 瀑布流ViewGroup";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.layout_widget_zflowlayout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

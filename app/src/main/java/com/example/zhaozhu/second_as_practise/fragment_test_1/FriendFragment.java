package com.example.zhaozhu.second_as_practise.fragment_test_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;

/**
 * Created by zhaozhu on 16/11/5.
 */

public class FriendFragment extends MBaseFragment {

    @Override
    public String getFragmentDesc() {
        return FriendFragment.class.getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        return view;
    }


}

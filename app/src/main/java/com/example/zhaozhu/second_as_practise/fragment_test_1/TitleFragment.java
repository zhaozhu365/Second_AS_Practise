package com.example.zhaozhu.second_as_practise.fragment_test_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 16/11/5.
 */

public class TitleFragment extends MBaseFragment {

    @Override
    public String getFragmentDesc() {
        return TitleFragment.class.getSimpleName();
    }

    @BindView(R.id.id_title_left_btn)
    ImageView mIdTitleLeftBtn;
    @BindView(R.id.id_title)
    TextView mIdTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mIdTitleLeftBtn.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "title fragment", Toast.LENGTH_SHORT).show();
        }
    };


}

package com.example.zhaozhu.second_as_practise.fragment_test_1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhaozhu.second_as_practise.MBaseFragment;
import com.example.zhaozhu.second_as_practise.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaozhu on 16/11/5.
 */

public class Test1Fragment extends MBaseFragment {

    @BindView(R.id.home_fragment)
    TextView mHomeFragmentBtn;
    @BindView(R.id.friend_fragment)
    TextView mFriendFragmentBtn;
    @BindView(R.id.contacts_fragment)
    TextView mContactsFragmentBtn;
    @BindView(R.id.profile_fragment)
    TextView mProfileFragmentBtn;

    private ContentFragment mHomeFragment;
    private FriendFragment mFriendFragment;

    @Override
    public String getFragmentDesc() {
        return Test1Fragment.class.getSimpleName() + ", 仅供测试,实际框架中的使用方法,参考yangzc";
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setDefaultFragment();
        initViews();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHomeFragment = new ContentFragment();
        transaction.replace(R.id.id_fragment_content, mHomeFragment);
        transaction.commit();
    }

    private void initViews() {
        mHomeFragmentBtn.setOnClickListener(mClickListener);
        mFriendFragmentBtn.setOnClickListener(mClickListener);
        mContactsFragmentBtn.setOnClickListener(mClickListener);
        mProfileFragmentBtn.setOnClickListener(mClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            // 开启Fragment事务
            FragmentTransaction transaction = fm.beginTransaction();

            switch (v.getId()) {
                case R.id.home_fragment: {
                    //TODO 这种做法效率太低，需要优化
                    //TODO 用sparseArray + ViewPager + tab 方式优化
                    if (mHomeFragment == null) {
                        mHomeFragment = new ContentFragment();
                    }
                    // 使用当前Fragment的布局替代id_content的控件
                    transaction.replace(R.id.id_fragment_content, mHomeFragment);
                    break;
                }
                case R.id.friend_fragment: {
                    if (mFriendFragment == null) {
                        mFriendFragment = new FriendFragment();
                    }
                    // 使用当前Fragment的布局替代id_content的控件
                    transaction.replace(R.id.id_fragment_content, mFriendFragment);
                    //transaction.addToBackStack(null);
                    break;
                }
            }
            // transaction.addToBackStack();
            // 事务提交
            transaction.commit();
        }
    };



}

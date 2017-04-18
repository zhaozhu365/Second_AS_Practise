package com.example.zhaozhu.second_as_practise;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhaozhu on 16/11/5.
 */

public abstract class MBaseFragment extends Fragment {

    public abstract String getFragmentDesc();

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(getClass().getSimpleName(), "onInflate()");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(getClass().getSimpleName(), "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(getClass().getSimpleName(), "onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(getClass().getSimpleName(), "onViewCreated()");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(getClass().getSimpleName(), "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(getClass().getSimpleName(), "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getClass().getSimpleName(), "onDetach()");
    }
}

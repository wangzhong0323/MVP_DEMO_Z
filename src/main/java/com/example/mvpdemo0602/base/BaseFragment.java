package com.example.mvpdemo0602.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/11.
 */

public abstract class BaseFragment extends Fragment {


    public Context getApplication() {
        return getActivity();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (getLayoutId() >0) {
            view = inflater.inflate(getLayoutId(), null);
        }
        ButterKnife.bind(this,view);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}

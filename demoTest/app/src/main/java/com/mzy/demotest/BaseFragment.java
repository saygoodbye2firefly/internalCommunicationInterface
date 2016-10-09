package com.mzy.demotest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mzy.com.easytransmit.InsideUpdate;

public abstract class BaseFragment extends Fragment implements InsideUpdate.UpdateNotify {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(initViewLayout(), container, false);
        InsideUpdate.addClientNotify(this);
        initOnceData(layout);
        return layout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        InsideUpdate.removeClientNotify(this);
    }

    protected void initOnceData(View view) {
    }

    /***
     * 初始化Layout
     */
    public abstract int initViewLayout();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();
    }

    public abstract void initFragment();

    protected Fragment getFragment(String tag) {
        return this.getFragmentManager().findFragmentByTag(tag);
    }

    @Override
    public void updateUi(int action, Object... value) {
    }
}

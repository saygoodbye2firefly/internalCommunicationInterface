package com.mzy.demotest;

import android.app.Activity;
import android.os.Bundle;

import mzy.com.easytransmit.InsideUpdate;

public abstract class BaseActivity extends Activity implements InsideUpdate.UpdateNotify {
    private final static String TAG = "BaseFragmentActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InsideUpdate.addClientNotify(this);
        setContentView(initViewLayout());
        initActivity();
    }

    protected abstract void initActivity();

    public abstract int initViewLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        InsideUpdate.removeClientNotify(this);
    }

    @Override
    public void updateUi(int action, Object... value) {
    }
}

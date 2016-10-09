package com.mzy.demotest;

import android.view.View;
import android.widget.TextView;

import mzy.com.easytransmit.InsideUpdate;

public class MainFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "MainFragment";

    private TextView tv_main;
    private TextView tv_main_1;
    private TextView tv_main_2;
    private TextView tv_main_3;

    @Override
    public int initViewLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initOnceData(View view) {

        tv_main = (TextView) view.findViewById(R.id.tv_main);
        tv_main_1 = (TextView) view.findViewById(R.id.tv_main_test1);
        tv_main_2 = (TextView) view.findViewById(R.id.tv_main_test2);
        tv_main_3 = (TextView) view.findViewById(R.id.tv_main_test3);
    }

    @Override
    public void initFragment() {
        tv_main_1.setOnClickListener(this);
        tv_main_2.setOnClickListener(this);
        tv_main_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_main_test1:
                InsideUpdate.sendNotify(UpdateAction.MainAction.MAIN_1, tv_main_1.getText());
                break;
            case R.id.tv_main_test2:
                InsideUpdate.sendNotify(UpdateAction.MainAction.MAIN_2, tv_main_2.getText());
                break;
            case R.id.tv_main_test3:
                InsideUpdate.sendNotify(UpdateAction.MainAction.MAIN_3, tv_main_3.getText());
                break;
            default:
                break;
        }
        OpenDrawer();
    }

    public void OpenDrawer() {
        ((MainActivity) getActivity()).OpenDrawer();
    }

    @Override
    public void updateUi(int action, Object... value) {
        switch (action) {
            case UpdateAction.MenuAction.MENU_1:
            case UpdateAction.MenuAction.MENU_2:
            case UpdateAction.MenuAction.MENU_3:
                tv_main.setText((String) value[0]);
                break;
            default:
                break;
        }
    }
}

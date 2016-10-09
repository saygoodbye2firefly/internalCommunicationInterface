package com.mzy.demotest;

import android.view.View;
import android.widget.TextView;

import mzy.com.easytransmit.InsideUpdate;

public class MenuFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "MenuFragment";

    private TextView tv_menu;
    private TextView tv_menu_1;
    private TextView tv_menu_2;
    private TextView tv_menu_3;

    @Override
    public int initViewLayout() {
        return R.layout.fragment_menu;
    }


    @Override
    protected void initOnceData(View view) {
        tv_menu = (TextView) view.findViewById(R.id.tv_menu);
        tv_menu_1 = (TextView) view.findViewById(R.id.tv_menu_test1);
        tv_menu_2 = (TextView) view.findViewById(R.id.tv_menu_test2);
        tv_menu_3 = (TextView) view.findViewById(R.id.tv_menu_test3);
    }

    @Override
    public void initFragment() {
        tv_menu_1.setOnClickListener(this);
        tv_menu_2.setOnClickListener(this);
        tv_menu_3.setOnClickListener(this);

    }

    @Override
    public void updateUi(int action, Object... value) {
        switch (action) {
            case UpdateAction.MainAction.MAIN_1:
            case UpdateAction.MainAction.MAIN_2:
            case UpdateAction.MainAction.MAIN_3:
                tv_menu.setText((String) value[0]);
                break;
            default:
                break;
        }
    }

    public void closeDrawer() {
        ((MainActivity) getActivity()).closeDrawer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_menu_test1:
                InsideUpdate.sendNotify(UpdateAction.MenuAction.MENU_1, tv_menu_1.getText());
                closeDrawer();
                break;
            case R.id.tv_menu_test2:
                InsideUpdate.sendNotify(UpdateAction.MenuAction.MENU_2, tv_menu_2.getText());
                closeDrawer();
                break;
            case R.id.tv_menu_test3:
                InsideUpdate.sendNotify(UpdateAction.MenuAction.MENU_3, tv_menu_3.getText());
                closeDrawer();
                break;
            default:
                break;
        }
    }


}

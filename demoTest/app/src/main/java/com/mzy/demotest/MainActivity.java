package com.mzy.demotest;

import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;

public class MainActivity extends BaseActivity {

    private final static String TAG = "MainActivity";

    private final static String TAG_MAIN = MainFragment.TAG;
    private final static String TAG_MENU = MenuFragment.TAG;

    protected DrawerLayout mDrawer_layout;

    @Override
    protected void initActivity() {
        mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);


        MainFragment mainFragment = new MainFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_main, mainFragment, TAG_MAIN)
                .commit();// 提交本次操作


        MenuFragment menuFragment = new MenuFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_menu, menuFragment, TAG_MENU)
                .commit();// 提交本次操作

        mDrawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawer_layout.setFocusableInTouchMode(false);
        //一定要加上 不然不会响应activity的 onkeydown或onBackPressed
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyDown: 11111");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawer_layout.isDrawerOpen(Gravity.RIGHT)) {
                mDrawer_layout.closeDrawers();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    /***
     * 获得mainFragment 通过tag名
     */
    public MainFragment getMainFragment() {
        return (MainFragment) getFragmentManager().findFragmentByTag(TAG_MAIN);
    }

    /***
     * 获得mainFragment 通过tag名
     */
    public MenuFragment getMenuFragment() {
        return (MenuFragment) getFragmentManager().findFragmentByTag(TAG_MENU);
    }

    @Override
    public int initViewLayout() {
        return R.layout.activity_main;
    }

    public void OpenDrawer() {
        mDrawer_layout.openDrawer(Gravity.RIGHT);
    }

    public void closeDrawer() {
        if (mDrawer_layout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawer_layout.closeDrawers();
        }
    }
}

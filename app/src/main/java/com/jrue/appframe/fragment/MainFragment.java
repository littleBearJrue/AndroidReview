package com.jrue.appframe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jrue.appframe.R;
import com.jrue.appframe.lib.base.BaseFragment;
import com.jrue.appframe.lib.event.OnBackPressedCtrlEvent;
import com.jrue.appframe.lib.widget.TitleBarLayout;

import butterknife.OnClick;

/**
 * Created by jrue on 17/2/5.
 */
public class MainFragment extends BaseFragment {

    public static final String TAG = "MainFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAutoRegisterEvent(true);
    }

    @Override
    public View mzOnCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void mzOnViewCreated(View view) {
        super.mzOnViewCreated(view);
    }

    @Override
    public void onResume() {
        super.onResume();

        TitleBarLayout bar = getTitleBarLayout();
        if (bar != null) {
            bar.setTitleBackground(TitleBarLayout.TITLE_BACKGROUND_GRAY);
            bar.setTitleGravity(TitleBarLayout.TITLE_GRAVITY_CENTER);
            bar.setTitleText("首页");
            bar.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.aboutAndroid)
    void onAndroid() {
        addFragmentToBackStack(new HomeAndroidFragment());
    }

    @OnClick(R.id.aboutJava)
    void onJava() {
        addFragmentToBackStack(new HomeJavaFragment());
    }

    @OnClick(R.id.aboutAlgorithm)
    void onAlgorithm() {
        addFragmentToBackStack(new HomeAlgorithmFragment());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onEvent(OnBackPressedCtrlEvent event) {
        getBaseActivity().mzFinish();
    }
}

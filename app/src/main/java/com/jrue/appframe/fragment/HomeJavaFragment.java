package com.jrue.appframe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrue.appframe.R;
import com.jrue.appframe.lib.base.BaseFragment;
import com.jrue.appframe.lib.event.OnBackPressedCtrlEvent;
import com.jrue.appframe.lib.util.MJava;
import com.jrue.appframe.lib.widget.TitleBarLayout;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by jrue on 17/2/27.
 */
public class HomeJavaFragment extends BaseFragment {
    public static final String TAG = "HomeJavaFragment";

    @Bind(R.id.strChange)
    TextView strChangeShown;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAutoRegisterEvent(true);
    }

    @Override
    public View mzOnCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.about_java_layout, container, false);
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
            bar.setTitleText("Java知识汇总");
            bar.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.btnStrChange)
    void onStrChange() {
        String result = MJava.StrChange("I love you !!!");
        strChangeShown.setText(result);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onEvent(OnBackPressedCtrlEvent event) {
        getFragmentManager().popBackStack();
    }
}

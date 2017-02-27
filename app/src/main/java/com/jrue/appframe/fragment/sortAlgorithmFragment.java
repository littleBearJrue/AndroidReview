package com.jrue.appframe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrue.appframe.R;
import com.jrue.appframe.lib.base.BaseFragment;
import com.jrue.appframe.lib.event.OnBackPressedCtrlEvent;
import com.jrue.appframe.lib.widget.TitleBarLayout;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by jrue on 17/2/27.
 */
public class sortAlgorithmFragment extends BaseFragment {
    public static final String TAG = "sortAlgorithmFragment";

    @Bind(R.id.originData)
    TextView originData;
    @Bind(R.id.sortResult)
    TextView sortResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAutoRegisterEvent(true);
    }

    @Override
    public View mzOnCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.sort_algorithm_layout, container, false);
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
            bar.setTitleText("算法知识汇总");
            bar.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.bubbleSort)
    void onBubbleSort() {

    }

    @OnClick(R.id.selectSort)
    void onSelectSort() {

    }

    @OnClick(R.id.insertSort)
    void onInsertSort() {

    }

    @OnClick(R.id.mergeSort)
    void onMergeSort() {

    }

    @OnClick(R.id.quickSort)
    void onQuickSort() {

    }

    @OnClick(R.id.shellSort)
    void onShellSort() {

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onEvent(OnBackPressedCtrlEvent event) {
        getFragmentManager().popBackStack();
    }
}

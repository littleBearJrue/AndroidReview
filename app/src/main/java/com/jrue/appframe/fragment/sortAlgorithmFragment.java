package com.jrue.appframe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrue.appframe.R;
import com.jrue.appframe.lib.base.BaseFragment;
import com.jrue.appframe.lib.event.OnBackPressedCtrlEvent;
import com.jrue.appframe.lib.util.MSort;
import com.jrue.appframe.lib.widget.TitleBarLayout;

import java.util.Arrays;

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

    int[] origin;

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

    @OnClick(R.id.randomBtn)
    void onRandomArray() {
        origin = MSort.randomArray();
        originData.setText(Arrays.toString(origin));
        sortResult.setText("Result");
    }

    @OnClick(R.id.bubbleSort)
    void onBubbleSort() {
        execSortFromType(MSort.SORT_BUBBLE);
    }

    @OnClick(R.id.selectSort)
    void onSelectSort() {
        execSortFromType(MSort.SORT_SELECT);
    }

    @OnClick(R.id.insertSort)
    void onInsertSort() {
        execSortFromType(MSort.SORT_INSERT);
    }

    @OnClick(R.id.mergeSort)
    void onMergeSort() {
        execSortFromType(MSort.SORT_MERGE);
    }

    @OnClick(R.id.quickSort)
    void onQuickSort() {
        execSortFromType(MSort.SORT_QUICK);
    }

    @OnClick(R.id.shellSort)
    void onShellSort() {
        execSortFromType(MSort.SORT_SHELL);
    }

    public void execSortFromType(String type) {
        int[] result = null;
        switch (type) {
            case MSort.SORT_BUBBLE: {
                result = MSort.bubbleSort(origin);
                break;
            }
            case MSort.SORT_INSERT: {
                result = MSort.insertSort(origin);
                break;
            }
            case MSort.SORT_SELECT: {
                result = MSort.selectSort(origin);
                break;
            }
            case MSort.SORT_QUICK: {
                result = MSort.quickSort(origin, 0, origin.length - 1);
                break;
            }
            case MSort.SORT_MERGE: {
                break;
            }
            case MSort.SORT_SHELL: {
                break;
            }
        }
        sortResult.setText(Arrays.toString(result));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onEvent(OnBackPressedCtrlEvent event) {
        getFragmentManager().popBackStack();
    }
}

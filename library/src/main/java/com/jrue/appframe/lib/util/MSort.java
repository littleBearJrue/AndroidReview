package com.jrue.appframe.lib.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述： 算法基本库
 * Created by jrue on 17/2/27.
 */
public class MSort {
    public static final String TAG = "MSort";

    public static final String SORT_BUBBLE = "bubble";
    public static final String SORT_INSERT = "insert";
    public static final String SORT_SELECT = "select";
    public static final String SORT_MERGE = "merge";
    public static final String SORT_QUICK = "quick";
    public static final String SORT_SHELL = "shell";

    /**
     * 冒泡排序：
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param num
     */
    public static int[] bubbleSort(int[] num) {
        int length = num.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    execChange(num, j, j + 1);
                }
            }
        }
        return num;
    }

    /**
     * 插入排序：
     * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
     * @param num
     * @return
     */
    public static int[] insertSort(int[] num) {
        int length = num.length;
        for (int i = 0 ; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (num[j] < num[j - 1]) {
                    execChange(num, j, j - 1);
                }
            }
        }
     return num;
    }

    /**
     * 选择排序：
     * 从所有序列中先找到最小的，然后放到第一个位置。之后再看剩余元素中最小的，放到第二个位置……以此类推，就可以完成整个的排序工作
     * @param num
     * @return
     */
    public static int[] selectSort(int[] num) {
        int length = num.length;
        for (int i = 0; i < length - 1; i++) {
            int currentMin = i;
            for (int j = i + 1; j < length; j++) {
                if (num[j] < num[currentMin]) {
                    currentMin = j;
                }
            }
            if (currentMin != i) {
                execChange(num, i, currentMin);
            }
        }
        return num;
    }


    /**
     * 快速排序：
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     * 先从后向前找，再从前向后找
     * @param num
     * @return
     */
    public static int[] quickSort(int[] num, int left, int right) {
        if (left < right) {
            int index = partitionOfQuickSort(num, left, right);
            quickSort(num, left, index - 1);
            quickSort(num, index, right);
        }

        return num;
    }

    /**
     * 快速排序基础判断操作
     * @param num
     * @param left
     * @param right
     * @return
     */
    private static int partitionOfQuickSort(int[] num, int left, int right) {
        if (num == null || num.length <= 0 || left < 0 || right > num.length) {
            return 0;
        }
        int point = num[left + (right - left) / 2];  //取中间的数作为基准数
        while (left <= right) {
            while (num[left] < point) left++;   //找出左边大于基准数的值
            while (num[right] > point) right--;   //找出右边小于基准数的值
            if (left <= right) {
                execChange(num, left, right);   //交换之间的位置
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * 归并排序：
     * 所谓归并是指将若干个已排好序的部分合并成一个有序的部分。
     * @param num
     * @return
     */
    public static int[] mergeSort(int[] num, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(num, low, mid);
            mergeSort(num, mid + 1, high);
            // 实现左右归并
            merge(num, low, mid, high);
        }
        return num;
    }

    private static void merge(int[] num, int low, int mid, int high) {
        int left = low;  //左指针
        int right = mid + 1;    //右指针
        int i = 0;
        int[] temp = new int[high - low + 1];

        //将两边最小的数先移到临时数组中
        while (left <= mid && right <= high) {
            if (num[left] < num[right]) {
                temp[i++] = num[left++];
            } else {
                temp[i++] = num[right++];
            }
        }
        // 将左边剩余的数组放进临时数组
        while (left <= mid) {
            temp[i++] = num[left++];
        }
        // 将右边剩余的数组放进临时数组
        while (right <= high ) {
            temp[i++] = num[right++];
        }
        // 临时数组覆盖原数组
        for (int j = 0; j < temp.length; j++) {
            num[j + low] = temp[j];
        }
    }

    /**
     * Shell排序： 插入排序升级版
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * @param num
     * @return
     */
    public static int[] shellSort(int[] num) {
        return num;
    }

    /**
     * 实现交换
     *
     * @param num 交换数组
     * @param i   第一下标
     * @param min 第二下标
     */
    public static void execChange(int[] num, int i, int min) {
        int temp = num[i];
        num[i] = num[min];
        num[min] = temp;
    }

    public static int[] randomArray() {
        List<Integer> list = new ArrayList<>();
        int total = (int) (20 * Math.random());
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            result[i] = i + ((int)(10 * Math.random()));
        }
        for (int i = 0; i < total; i++) {
            int random = (int) (total * Math.random());
            execChange(result, i, random);
        }

        return result;
    }


}

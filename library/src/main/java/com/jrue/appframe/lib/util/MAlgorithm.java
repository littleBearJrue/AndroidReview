package com.jrue.appframe.lib.util;

/**
 * 描述：算法基础题汇总
 * Created by jrue on 17/3/13.
 */
public class MAlgorithm {

    /** 题型:
     * 请实现一个函数，输入一个整数，输出该数的二进制表示中的1的个数
     * tip:把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于吧整数的二进制表示中的最右边1变成0
     *
     * @param input
     */
    public static int checkNumOne(int input) {
        int num = 0;
        if (input == 0) {
            return 0;
        }
        while (input != 0) {
            num++;
            input = (input - 1) & input;
        }
        return num;
    }

    /** 题型：
     * 实现一个函数可以求其的次方(最优解)？
     * @param base
     * @param exponent
     * @return
     */
    public static double createPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        double result = createPower(base, exponent >> 1); //右移实现除以2
        result *= result;
        if ((exponent & 0x01) == 1) {
            result *= base;
        }
        return result;
    }


    /** 题型：
     * 左转字符串：如abcXYZdef 经过左旋后为 XYZdefabc
     * 思路：旋转前n个字符串，再旋转n后的字符串，最后整体旋转
     */
    public static String reverseSentence(String sentence, int n) {
        if (sentence == null || sentence.length() < 2 || sentence.length() <= n) {
            return sentence;
        }
        char[] charArray = sentence.toCharArray();
        // 翻转前n个
        reverse(charArray, 0, n - 1);
        // 翻转后n个
        reverse(charArray, n, charArray.length - 1);
        // 翻转整个句子
        reverse(charArray, 0, charArray.length - 1);
        return String.valueOf(charArray);
    }

    private static void reverse(char[] array, int i, int j) {
        if (i < 0 || j <0 || i > j) {
            return;
        }
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    /** 题型： 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
     *
     */
    public int removeSameNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        } else {
            int temp = array[0];
            int len = 1;
            for (int i = 1; i < array.length; i++) {
                if (temp == array[i]) {
                    continue;
                } else {
                    temp = array[i];
                    array[len] = array[i];
                    len++;
                }
            }
            return len;
        }
    }



}

package com.jrue.appframe.lib.util;

import java.util.Stack;

/**
 * 描述： 关于Java的一些基本题型
 * Created by jrue on 17/3/7.
 */
public class MJava {

    /** 题型：
     * 在一个二维数组中,每一行都按照从左到右递增的顺序排序,每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数,输入这样的一个二维数组和一个整数,判断数组中是否函数该整数。
     * @param arr
     * @param value
     * @return
     */
    public static boolean findConcreteData(int[][] arr, int value) {
        int rowLength = arr.length;
        int columnLength = arr[0].length;
        int i = 0;
        int j = columnLength - 1;
        while (i < rowLength - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            } else if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /** 题型：
     * 请实现一个函数，把字符串中的每个空格替换成"%20"：例如输入"We are happy"，则输出"We%20are%20happy"
     * @param originStr
     * @return
     */
    public static String StrChange(String originStr){
        char[] charArrays = originStr.toCharArray();
        int length = charArrays.length;
        int count = 0;
        //计算目前字符串空格个数
        for (int i = 0; i < length; i++) {
            if (charArrays[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        int j = 0;
        int k = 0;
        char[] temp = new char[length + 2 * count];
        while (j <= length + 2 * count - 1) {
            if (charArrays[k] == ' ') {
                temp[j] = '%';
                temp[j + 1] = '2';
                temp[j + 2] = '0';
                j = j + 3;
            } else {
                temp[j] = charArrays[k];
                j++;
            }
            k++;
        }
        return new String(temp);
    }

    /**题型：
     * 通过两个栈建立队列
     *
     */
    public static void queueFromStack() {
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        queuePush(s1, "a");
        queuePush(s1, "b");
        queuePush(s1, "c");
        queuePoll(s1, s2);

    }

    private static void queuePush(Stack stack, Object o) {
        stack.push(o);
    }

    private static void queuePoll(Stack s1, Stack s2) {
        if (s1.size() == 0 && s2.size() == 0) {
            try {
                throw new Exception("queue is free");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (s2.size() != 0) {
                s2.pop();
            } else {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                    s2.pop();
                }

            }
        }
    }

    /**题型：
     * 公司员工几万人，实现对员工年龄的排序算法，算法时间复杂度为O(n)
     * @param ages
     * @param length
     * @return
     */
    public static int[] ageSort(int[] ages, int length) {

        return null;
    }
}

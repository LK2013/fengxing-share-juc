package com.share.juc.threadpool.utils;

import java.util.Random;

/**
 * @ClassName: Utils
 * @package com.share.juc.threadpool.utils
 * @author: fengxing
 * @date: 2020/10/13 15:20
*/
public class Utils {

    public static int[] buildRandomIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public static int[] buildRandomIntArray() {
        int size = new Random().nextInt(100);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ints = Utils.buildRandomIntArray(20000);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
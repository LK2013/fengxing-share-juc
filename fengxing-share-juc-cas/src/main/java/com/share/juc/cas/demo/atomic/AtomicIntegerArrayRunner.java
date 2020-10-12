package com.share.juc.cas.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Atomic int数组。注意，不会修改原数组的值。
 * @ClassName: AtomicIntegerArrayRunner
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 16:25
*/
public class AtomicIntegerArrayRunner {

    static int[] value = new int[]{1,2};
    static AtomicIntegerArray aiArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        //todo 原子修改数组下标0的数值
        aiArray.getAndSet(0,3);
        System.out.println(aiArray.get(0));
        System.out.println(value[0]);
}

}

package com.share.juc.cas.demo.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 引用类型Array，atomic
 * @ClassName: AtomicReferenceArrayRunner
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 16:43
*/
public class AtomicReferenceArrayRunner {

    static Tuling[] ovalue = new Tuling[]{new Tuling(1),new Tuling(2)};
    static AtomicReferenceArray<Tuling> objarray = new AtomicReferenceArray(ovalue);

    public static void main(String[] args) {
        System.out.println(objarray.get(0).getSequence());

        objarray.set(0,new Tuling(3));

        System.out.println(objarray.get(0).getSequence());

    }

}

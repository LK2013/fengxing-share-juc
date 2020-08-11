package com.share.juc.jmm.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnsafeInstanse
 * @Description TODO
 * @Author LKand
 * @Date 2020/8/10 11:33
 * @Version V1.0
 **/
public class UnsafeInstance {

    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
package com.share.juc.cas.demo.utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 魔术类实例
 * @ClassName: UnsafeInstance
 * @package com.share.juc.cas.demo.utils
 * @author: fengxing
 * @date: 2020/10/12 16:30
*/
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

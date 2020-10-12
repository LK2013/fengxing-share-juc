package com.share.juc.cas.demo.unsafe;

import com.share.juc.cas.demo.utils.UnsafeInstance;
import sun.misc.Unsafe;

/**
 * 魔法类修改内存值
 * @ClassName: AllocateMemoryAccess
 * @package com.share.juc.cas.demo.unsafe
 * @author: fengxing
 * @date: 2020/10/12 16:31
*/
public class AllocateMemoryAccess {

    public static void main(String[] args) {
        Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
        long oneHundred = 1193123491341341234L;
        byte size = 8;
        /*
         * 调用allocateMemory分配内存
         */
        long memoryAddress = unsafe.allocateMemory(size);
        System.out.println("address:->"+memoryAddress);
        /*
         * 将1写入到内存中
         */
        unsafe.putAddress(memoryAddress, oneHundred);
        /*
         * 内存中读取数据
         */
        long readValue = unsafe.getAddress(memoryAddress);

        System.out.println("value : " + readValue);

        unsafe.freeMemory(memoryAddress);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

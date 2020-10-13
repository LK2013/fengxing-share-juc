package com.share.juc.threadpool.utils;

import java.math.BigInteger;

/**
 * @ClassName: CalcUtil
 * @package com.share.juc.threadpool.utils
 * @author: fengxing
 * @date: 2020/10/13 15:20
*/
public class CalcUtil {

    public static BigInteger calculateFactorial(BigInteger param) {

        return cal(param);
    }

    private static BigInteger cal(BigInteger param) {
        if (param.intValue() == 1) {
            return param;
        }

        BigInteger result = new BigInteger(param.toString());

        BigInteger subtract = result.subtract(new BigInteger("1"));

        result = result.multiply(cal(subtract));

        return result;
    }
}
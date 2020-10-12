package com.share.juc.cas.demo.atomic;

import lombok.Data;

/**
 *
 * @ClassName: Tuling
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 16:45
*/
@Data
public class Tuling {

    private Integer sequence;

    public Tuling(Integer seq){
        sequence = seq;
    }
}

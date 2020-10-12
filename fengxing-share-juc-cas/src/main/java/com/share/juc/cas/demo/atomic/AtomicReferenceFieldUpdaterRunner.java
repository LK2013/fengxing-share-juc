package com.share.juc.cas.demo.atomic;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.UnaryOperator;

/**
 * 引用类型字段修改，atomic
 * @ClassName: AtomicReferenceFieldUpdaterRunner
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 17:10
*/
public class AtomicReferenceFieldUpdaterRunner {

    static AtomicReferenceFieldUpdater atomic = AtomicReferenceFieldUpdater.newUpdater(Document.class,String.class,"name");

    public static void main(String[] args) {
        Document document = new Document("李磊",1);

        System.out.println(atomic.get(document));

        atomic.getAndSet(document,"韩梅梅");

        System.out.println(atomic.get(document));

        //另一种方式修改
        UnaryOperator<String> uo = s->{
            System.out.println("UnaryOperator:-->"+s);
            return "韩梅梅";
        };
        System.out.println(atomic.getAndUpdate(document, uo));
        System.out.println(atomic.get(document));

    }

    @Data
    static class Document{
        public volatile String name;
        private int version;

        Document(String obj,int v){
            name = obj;
            version = v;
        }

    }
}

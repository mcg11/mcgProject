package com.thread;

/**
 * Created by macg11 on 2020/4/21.
 */
public class Counter {
    private long value=0;

     long geta(){
        return value;
    }

     long addOne(){
        return ++value;
    }

    public static void main(String[] args){
        Counter a1=new Counter();
        a1.addOne();
        Counter a2=new Counter();
        a2.addOne();
        Long aa2=a2.geta();
        Long aa1=a1.geta();
        System.out.println(aa1);
        System.out.println(aa2);


    }
}

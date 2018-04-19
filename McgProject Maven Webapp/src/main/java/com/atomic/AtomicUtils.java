package com.atomic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by macg11 on 2018/4/18.
 */
public class AtomicUtils {

    public static void main(String[] args){
        String aa="[3,4,5]";
        List a = Arrays.asList(aa);
        if(a.contains(3)){
            System.out.println("包含");
        }
    }

}

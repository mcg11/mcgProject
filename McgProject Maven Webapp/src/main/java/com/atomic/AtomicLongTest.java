package com.atomic;

import com.account.APITest.BaseControllerWebAppContextSetupTest;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by macg11 on 2018/4/17.
 */
public class AtomicLongTest extends BaseControllerWebAppContextSetupTest {

    @Test
    public void testAtomicLong(){
        AtomicLong atomic=new AtomicLong();
        atomic.set(2* 1000);
        Long currentMaxId = (2 + 1) * 1000L;

        for (int i=0;i<30;i++){
            Long nextId= atomic.incrementAndGet();
            System.out.println(nextId);
        }


    }
    @Test
    public void  aaaa(){
        String aa=null;
        String.valueOf(aa);
        System.out.println(aa);
    }
}

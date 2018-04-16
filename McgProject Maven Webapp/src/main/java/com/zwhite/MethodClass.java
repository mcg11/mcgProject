package com.zwhite;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by macg11 on 2018/4/12.
 */
public class MethodClass {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.zwhite.Student");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.print(field.getName() + ", ");
        }


        //1.2 获取指定名字的Field（如果是私有的，见下面的4)
        Field field = clazz.getDeclaredField("name");
        System.out.println("\n获取指定Field名=: " + field.getName());

        Student person = new Student("ABC", 12);
        //2、获取指定对象的Field的值
        Object val = field.get(person);
        System.out.println("获取指定对象字段'name'的Field的值=： " + val);


    }
}

package com.zwhite;

/**
 * Created by macg11 on 2018/4/12.
 */
public class Student {
    private String name;
    private int age;

    //新增一个私有方法
    private void privateMthod(){
    }

    public Student() {
        System.out.println("无参构造器");
    }

    public Student(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param age  类型用Integer，不用int
     */
    public void setName(String name , int age){
        System.out.println("name: " + name);
        System.out.println("age:"+ age);

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

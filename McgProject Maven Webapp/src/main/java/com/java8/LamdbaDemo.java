package com.java8;

/**
 * Created by macg11 on 2020/10/16.
 */
public class LamdbaDemo {
  interface Printer{
    void printer(String val);
  }
  public void doSomethings(String val,Printer p){
    p.printer(val);
  }
  public static void  main(String[] args){
    // LamdbaDemo demo=new LamdbaDemo();
    /*Printer printer=new Printer() {
      @Override
      public void printer() {

      }
    };
    String val="test";
    demo.doSomethings(val,printer);*/
    //lambda
    String some="test";

    // Printer printer=(String val)->{ System.out.println(val); };
    // Printer printer=(val)->{ System.out.println(val); };
    Printer printer=(val)->System.out.println(val);;


    // demo.doSomethings(some,printer);

    boolean r=!"aa".equals("aa");
    System.out.println(r);
    isPalindrome(34567);

  }
  public static boolean isPalindrome(int x) {
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    //ceshi

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    return x == revertedNumber || x == revertedNumber / 10;

  }
}


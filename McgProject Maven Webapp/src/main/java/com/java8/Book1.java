package com.java8;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by macg11 on 2020/10/16.
 */
public class Book1 {
  private String username;
  private String password;

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map=new HashMap<>();
    for (int i=0;i<nums.length; i++) {
      if(map.containsKey(target-nums[i])){
        return new int[]{ map.get(target-nums[i]),i};
      }
      map.put(nums[i],i);
    }
    return  new int[0];

  }

  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    int[] result=twoSum(new int[]{2,3,4,5,5},10);
    System.out.println(result);

  }
}

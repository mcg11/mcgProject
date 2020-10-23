package com.express;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by macg11 on 2020/9/22.
 */
public class Test {

  @org.junit.Test
  public void Test1() {
    int TH_TIMEZONEOFFSET = 25200;
    ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(TH_TIMEZONEOFFSET);
    Instant dd = Instant.parse("2019-11-11T00:00:00.00Z");
    LocalDate parcelDate = LocalDateTime.ofInstant(dd, zoneOffset).toLocalDate();
    LocalDate now = LocalDateTime.ofInstant(Instant.now(), zoneOffset).toLocalDate();
    System.out.println();
  }

  @org.junit.Test
  public void stream() {
    List<String> strings= Arrays.asList("abc","","bc","efg","abcd","","jkl");
    List<String> filtered=strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

    Random random=new Random();
    random.ints().limit(10).forEach(System.out::println);

    List<String> map=strings.stream().map(i ->i+"abc").distinct().collect(Collectors.toList());

    String coll=strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));

    System.out.println(coll);
  }
}
































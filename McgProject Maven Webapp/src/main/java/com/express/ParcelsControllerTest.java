package com.express;

import java.time.*;
import java.time.temporal.ChronoUnit;


/**
 * Created by macg11 on 2020/9/22.
 */
public class ParcelsControllerTest {

    @org.junit.Test
    public void testReceiveWarehouseScan() throws Exception {
        ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(25200);

        LocalDateTime localDateTime = LocalDateTime.now().minusHours(2);
        Instant localDateTime2Instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        LocalDate parcelDate = LocalDateTime.ofInstant(localDateTime2Instant, zoneOffset).toLocalDate();
        System.out.println(parcelDate);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(ChronoUnit.DAYS.between(parcelDate, localDate));

        if (ChronoUnit.DAYS.between(parcelDate, localDate) >= 1) {
            System.out.println("不同一天");
        } else {
            System.out.println("是同一天");

        }


    }
}

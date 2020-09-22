package com.mcg;

import org.junit.Test;

import java.io.*;

/**
 * Created by macg11 on 2018/8/28.
 */
public class readFile {
    @Test
    public  void testaa () throws Exception{
        String encoding = "utf-8";
        String fileName="/Users/hehaifeng/000000_0";
        String aa=read(fileName, encoding);
        String[] bb=aa.split("\u0001");

        System.out.println();
    }

    public static String read(String path, String encoding) throws IOException {
        String content = "";
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), encoding));
        String line = null;
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        return content;
    }


}

package com.mcg;

import com.account.APITest.BaseControllerWebAppContextSetupTest;
import com.ziroom.common.util.NetUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2017/8/8.
 */
public class checkAccountTest  extends BaseControllerWebAppContextSetupTest {

    @Test
    public void testBlackUid()throws Exception{
        InputStream is = new FileInputStream("/Users/hehaifeng/uid.xlsx");//fileUrl如：d:\\.xlsx"
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowNum = xssfSheet.getLastRowNum();
        List<Object> list = new ArrayList<Object>();
        for(int i =1;i<=rowNum;i++){
            Object obj = null;
            XSSFRow xssfRow = xssfSheet.getRow(i);
            if (xssfRow != null) {
                for (int colNum = 0; colNum < xssfRow.getLastCellNum(); colNum++) {
                    String uid = getValue(xssfRow.getCell(colNum)).trim();
                    //调用
                    Map<String,String> map=new HashMap<String, String>();
                    map.put("uid",uid);
                    String url = "http://accountck.ziroom.com/syncZC/checkBlackUid.do";

                    InputStream resultContentInputStream = NetUtil.sendPostRequest(
                            url, map);

                    String resultContent = NetUtil.getTextContent(resultContentInputStream,
                            "UTF-8");
                    System.out.println(resultContent);
                }
            }
        }
    }
    public  String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("0");
            String strCell = df.format(xssfRow.getNumericCellValue());
            return strCell;
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

}

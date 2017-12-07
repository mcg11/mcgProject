package com.mcg;

import com.account.APITest.BaseControllerWebAppContextSetupTest;
import com.account.APITest.EncryptionUtil;
import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by macg11 on 2017/8/8.
 */
public class exportAccountTest extends BaseControllerWebAppContextSetupTest {

    //导出有uid的余额
    @Test
    public void testBlackUid()throws Exception{
        InputStream is = new FileInputStream("/Users/hehaifeng/uid.xlsx");//fileUrl如：d:\\.xlsx"
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowNum = xssfSheet.getLastRowNum();
        List<Object> list = new ArrayList<Object>();
        List<Map<String,Object>> list2=new ArrayList<Map<String, Object>>();
        List<String> ss=new ArrayList<String>();
        for(int i =1;i<=rowNum;i++){
            Object obj = null;
            XSSFRow xssfRow = xssfSheet.getRow(i);
            if (xssfRow != null) {
                for (int colNum = 0; colNum < xssfRow.getLastCellNum(); colNum++) {
                    String uid = getValue(xssfRow.getCell(colNum)).trim();
//                    //调用
//                    Map<String,String> map=new HashMap<String, String>();
//                    map.put("uid",uid);



                    JSONObject jsonObjAddAccount = new JSONObject();
                    jsonObjAddAccount.put("uid", uid);
                    jsonObjAddAccount.put("systemSource", "dz");

                    // 加密
                    Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                            jsonObjAddAccount.toString(), key_ziroom);
                    String encryption = (String) resultMap.get("encryption");


                    String encryption1 = encryption.replace("/", "%2F");
                    String encryption2 = encryption1.replace("+", "%2B");
                    String encryption3 = encryption2.replace("=", "%3D");



                     String url = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do";

                    InputStream resultContentInputStream = NetUtil.sendPostRequest(
                            url, resultMap);

                    String resultContent = NetUtil.getTextContent(resultContentInputStream,
                            "UTF-8");

                    JSONObject result=JSONObject.fromObject(resultContent);
                    JSONObject data=JSONObject.fromObject(result.get("data"));
//                   String balance=JSONObject. data.get("balance");
                    Map<String,Object> map=new HashMap<String, Object>();
                   Integer money= data.getInt("balance");
                    System.out.println("第几个："+i);


                    if(money<0){
                       ss.add("uid:"+uid+",余额："+money);


                   }
                }
            }

        }
        System.out.println("总个数有："+ss.size());

//        exportExcel(list2);
        File file = new File("/Users/hehaifeng/test.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        Iterator<String> iter = ss.iterator();
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            while(iter.hasNext()) {
                bw.write(iter.next());
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
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

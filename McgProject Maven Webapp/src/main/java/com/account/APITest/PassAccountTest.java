package com.account.APITest;


import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName: PassAccountTest
 * 
 * @Description: 充值消费
 * @author liuxm
 * @date 2014年11月15日
 */
public class PassAccountTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(PassAccountTest.class);

	public PassAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 充值消费Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void passAccountTest() throws Exception {
		
		// 获取流水号
		String tradeNo = "";

		// json数据
		JSONObject jsonObjPassAccount = new JSONObject();
		jsonObjPassAccount.put("uid", "1fde9c59-b988-464d-9bdd-9606626fa0ff");
		jsonObjPassAccount.put("trade_no", "5fcfd32e29f3e0d6b7e41b6b4ed19172shoubu");
		jsonObjPassAccount.put("total_fee", 3476000);
		jsonObjPassAccount.put("biz_common", "pay_to_account_pass");
		 jsonObjPassAccount.put("description", "产品让转生活到广州");
		jsonObjPassAccount.put("city_code", 801000);
		jsonObjPassAccount.put("pay_type", "wx_ios_pay");
		//jsonObjPassAccount.put("business_type","living_cost");
		//jsonObjPassAccount.put("sys_source", "living_cost");

		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjPassAccount.toString(), key_ziroom);
		String encryption = (String) resultMap.get("encryption");
		if (encryption.equals("")) {
			logger.error((String) resultMap.get("error"));
			return;
		}

		// 打印传递的参数
		logger.info(encryption);

		String encryption1 = encryption.replace("/", "%2F");
		String encryption2 = encryption1.replace("+", "%2B");
		String encryption3 = encryption2.replace("=", "%3D");

		// System.out.println(encryption3);

		//String refundUrl = "http://account.t.ziroom.com/passAccount.html";
        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/passAccount.do";
		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		/*
		 * // 打印传递的参数 logger.info(encryption);
		 * 
		 * MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path +
		 * "passAccount.do?encryption=" + encryption); // 请求 ResultActions
		 * result = mockMvc.perform(mo).andExpect(
		 * MockMvcResultMatchers.jsonPath("$.meta.status") .value("SUCCESS"));
		 * // 日志 返回值详情 logger.info("单元测试  passAccountTest result is " +
		 * result.andReturn().getResponse().getContentAsString());
		 */
	}
	@Test
	public void passAccountTestBatch() throws Exception {

		InputStream is = new FileInputStream("d:\\111.xlsx");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		int rowNum = xssfSheet.getLastRowNum();
		List<Object> list = new ArrayList<Object>();
		for(int i =1;i<=rowNum;i++){
			
			Object obj = null;
			XSSFRow xssfRow = xssfSheet.getRow(i);
			if (xssfRow != null) {
				for (int colNum = 0; colNum < xssfRow.getLastCellNum(); colNum++) {
					obj = getValue(xssfRow.getCell(colNum)).trim();
					list.add(obj);
				}
			}
		}
		System.out.println("解析出的list：=====" + list);
		
		
		
		String uid="";
		String trade_no="";
		String total_fee="";
		String biz_common="";
		String city_code="";
		String pay_type="";
		
		
		// 获取流水号
		String tradeNo = "";

		// json数据
		JSONObject jsonObjPassAccount = new JSONObject();
		jsonObjPassAccount.put("uid", "d3ed59d8-7a46-cd72-12e3-31415b50362b");
		jsonObjPassAccount.put("trade_no", "WXAPP147427488624610000000801511");
		jsonObjPassAccount.put("total_fee", 121);
		jsonObjPassAccount.put("biz_common", "pay_to_account_pass");
		// jsonObjPassAccount.put("description", TESTFALG + "充值消费");
		jsonObjPassAccount.put("city_code", 801500);
		jsonObjPassAccount.put("pay_type", "wx_ios_pay");
		//jsonObjPassAccount.put("business_type","living_cost");
		//jsonObjPassAccount.put("sys_source", "living_cost");

		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjPassAccount.toString(), key_ziroom);
		String encryption = (String) resultMap.get("encryption");
		if (encryption.equals("")) {
			logger.error((String) resultMap.get("error"));
			return;
		}

		// 打印传递的参数
		logger.info(encryption);

		String encryption1 = encryption.replace("/", "%2F");
		String encryption2 = encryption1.replace("+", "%2B");
		String encryption3 = encryption2.replace("=", "%3D");

		// System.out.println(encryption3);

		//String refundUrl = "http://account.t.ziroom.com/passAccount.html";
		String refundUrl = "http://localhost:8080/account/passAccount.do";
		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		
	}
	
	public static String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("0");  
		     String strCell = df.format(xssfRow.getNumericCellValue()); 
//			xssfRow.setCellType(xssfRow.CELL_TYPE_STRING);
//			return String.valueOf(xssfRow.getStringCellValue());
			return strCell;
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
		/*
		 * // 打印传递的参数 logger.info(encryption);
		 * 
		 * MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path +
		 * "passAccount.do?encryption=" + encryption); // 请求 ResultActions
		 * result = mockMvc.perform(mo).andExpect(
		 * MockMvcResultMatchers.jsonPath("$.meta.status") .value("SUCCESS"));
		 * // 日志 返回值详情 logger.info("单元测试  passAccountTest result is " +
		 * result.andReturn().getResponse().getContentAsString());
		 */
	}
}

/**
 * 
 */
package com.account.APITest;

import com.ziroom.common.util.DateUtil;
import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * ClassName: AddAccountTest
 * 
 * @Description: 账户充值测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class AddAccountTest extends BaseControllerWebAppContextSetupTest {

    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(AddAccountTest.class);

    /**
     *
     */
    public AddAccountTest() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 账户充值Test
     *
     * @throws Exception
     */
    @Test
    public void addAccountTest() throws Exception {

        // 获取流水号
        String tradeNo = "";

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "554a4acf-87cf-430b-a293-0fca2172dc74");
        jsonObjAddAccount.put("trade_no", "budan_a85619554a5cb5_151shoudongbu");
        jsonObjAddAccount.put("total_fee", 3476000);
        jsonObjAddAccount.put("biz_common", "finance_add_account");//
        // 账户充值业务类型
        // jsonObjAddAccount.put("description",
        // TESTFALG
        // +
        // " 账户充值");
        jsonObjAddAccount.put("description", "生活转到广州");
        jsonObjAddAccount.put("city_code", "440100");
        jsonObjAddAccount.put("pay_type", "finance_redPacket");
        jsonObjAddAccount.put("sys_source", "finance");
        jsonObjAddAccount.put("pay_time", "2019-01-14 17:06:44");
//        jsonObjAddAccount.put("order_id", "budan_a85619554a5cb5_151ceshitixian");
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjAddAccount.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        // System.out.println(encryption3);

//        String refundUrl = "http://localhost:8083/account/addAccount.do";
		String refundUrl = "http://account.q.ziroom.com/addAccount.html";
//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/addAccount.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");

        System.out.println(resultContent);

        // logger.info(encryption);
        // MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
        // + "addAccount.do?encryption=" + encryption);
        // // 请求
        // ResultActions result = mockMvc.perform(mo);
        // .andExpect(
        // MockMvcResultMatchers.jsonPath("$.meta.status").value(
        // "SUCCESS"))
        // .andExpect(
        // MockMvcResultMatchers.jsonPath("$.result").value(
        // tradeNo + "_account"))
        // 日志 返回值详情
        // logger.info("单元测试  addAccountTest result is "
        // + result.andReturn().getResponse().getContentAsString());
    }
    public static  void main(String args[]) {





        // 取出最后更新时间
        String startTime = "2017-08-29 10:20:00";
        logger.info("sync.wtpay.last.time：" + startTime);
        // 判断从redis中取得值是否为空
        if (startTime != null && !"".equals(startTime)) {

            Date now = new Date();
            String nowTime=DateUtil.dateToStr(now, DateUtil.TIME_FORMAT);
            String endTime=DateUtil.getAnHourTime(startTime, Calendar.MINUTE, ConstantValue.SYNC_FIELD, null);
            String syncWTTime=DateUtil.getAnHourTime(startTime, Calendar.MINUTE, ConstantValue.SYNC_DISTANCE, null);
            //定时任务时间与系统当前时间差值
            long diff = 0;
            try {
                diff = DateUtil.dateDiff(DateUtil.strToDate(startTime, DateUtil.TIME_FORMAT), now, "M");


                //时间滞后  [startTime,当前系统时间-distance]
                if (diff >= ConstantValue.SYNC_FIELD + ConstantValue.SYNC_DISTANCE || diff < ConstantValue.SYNC_FIELD) {
                    endTime = DateUtil.getNearDisTime(nowTime, ConstantValue.SYNC_DISTANCE, DateUtil.TIME_FORMAT);
                    syncWTTime = DateUtil.getAnHourTime(endTime, Calendar.MINUTE, ConstantValue.SYNC_DISTANCE - ConstantValue.SYNC_FIELD, null);
                    //时间超前   [当前系统之间-distance,当前系统时间-distance]
                }
                if (diff < ConstantValue.SYNC_FIELD) {
                    syncWTTime = DateUtil.getNearDisTime(nowTime, ConstantValue.SYNC_DISTANCE, DateUtil.TIME_FORMAT);
                    syncWTTime = DateUtil.getAnHourTime(syncWTTime, Calendar.MINUTE, ConstantValue.SYNC_DISTANCE - ConstantValue.SYNC_FIELD, null);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 账户充值Test
     *
     * @throws Exception
     */
    @Test
    public void addAccountFWFTest() throws Exception {

        // 获取流水号
        String tradeNo = "";
        // json数据
        JSONArray array=new JSONArray();

        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "1fde9c59-b988-464d-9bdd-9606626fa0ff");
        jsonObjAddAccount.put("trade_no", "budan_aa5cb5_151shoudongbu");
        jsonObjAddAccount.put("total_fee", 3476000);
        jsonObjAddAccount.put("city_code", "440100");

        array.add(jsonObjAddAccount);
        jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "1fde9c59-b988-464d-9bdd-9606626fa0ff");
        jsonObjAddAccount.put("trade_no", "budanb5_151shoudongbu");
        jsonObjAddAccount.put("total_fee", 3476000);
        jsonObjAddAccount.put("city_code", "440100");
        array.add(jsonObjAddAccount);
        String aa=array.toString();
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                array.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        // System.out.println(encryption3);

//        String refundUrl = "http://localhost:8083/account/addAccountFWF.do";
		String refundUrl = "http://account.t.ziroom.com/addAccountFWF.html";
//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/addAccount.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");

        System.out.println(resultContent);


    }
}

package com.insure;

import com.account.APITest.EncryptionUtil;
import com.alibaba.fastjson.JSON;
import com.util.HttpRequestClient;
import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by macg11 on 2019/11/4.
 */
public class ReportTest {

    // 获取流水号
    String tradeNo = "";

    @Test
    public void testReoprt()throws Exception{


        // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("zrReportNo", "ZR20190220001107");
        map.put("accidentTime", "2019-10-12 10：22：22");
        map.put("accidentReason", "洗衣机泡水");
        map.put("houseNo", "BJW15911806");
        map.put("oneCode", "42");
        map.put("twoCode", "43");
        map.put("operName", "管家1");
        map.put("operCode", "20282202");
        map.put("operPhone", "15899999999");
        map.put("parentReportNo", "no");

        map.put("isInjured", "0");


        List<AttReq> attReqs=new ArrayList<AttReq>();
        AttReq vo=new AttReq();
//        vo.setAttType(1);
        vo.setAttUrl("http://10.16.34.42:8080/group3/M00/0C/72/ChAiKlrJeb-ADieIAAJujZIXTI0887.png");
        vo.setStuffType("200");
        attReqs.add(vo);
        vo=new AttReq();
//        vo.setAttType(1);
        vo.setAttUrl("http://10.16.34.42:8080/group3/M00/0C/76/ChAiKlrMkHqAS2AXAAPpTv-WneE267.png");
        vo.setStuffType("210");
        attReqs.add(vo);
        map.put("attList", JSON.toJSONString(attReqs));
//        vo.setAttType(1);
        vo.setAttUrl("http://10.16.34.42:8080/group3/M00/0C/76/ChAiKlrMkHqAS2AXAAPpTv-WneE267.png");
        vo.setStuffType("220");
        attReqs.add(vo);
        map.put("attList", JSON.toJSONString(attReqs));

        ContractPeopleVo contractPeopleVo=new ContractPeopleVo();
        List<ContractPeopleVo> vos=new ArrayList<ContractPeopleVo>();
        contractPeopleVo.setContactAmount("33");
        contractPeopleVo.setContactPeopleName("小米");
        contractPeopleVo.setContactPhone("15822223333");
        vos.add(contractPeopleVo);
        map.put("contactPeopleList", JSON.toJSONString(vos));

        List<TInjuredPerson> injuredPeopleList=new ArrayList<TInjuredPerson>();
        TInjuredPerson person=new TInjuredPerson();
        person.setInjuredAge("23");
        person.setInjuredAmount(new BigDecimal(33));
        person.setInjuredCardNo("330781198509070175");
        person.setInjuredCardType("01");
        person.setInjuredName("胡梅3");
        person.setInjuredSex(1);
        injuredPeopleList.add(person);
        map.put("injuredPersonList",JSON.toJSONString(injuredPeopleList));

        // 加密

//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure.t.ziroom.com/api/report/addReport";

        String resultContent = HttpRequestClient.postRequest(refundUrl, map);

        System.out.println(resultContent);

    }
    @Test
    public void buchong()throws Exception{


        // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("jsonAttment", "[{\"addTime\":1573027367679,\"caseType\":1,\"id\":769,\"stuffType\":\"200\",\"url\":\"http://10.16.34.42:8080/group3/M00/0C/72/ChAiKlrJeb-ADieIAAJujZIXTI0887.png\",\"zrReportNo\":\"ZR20190220002858\"},{\"addTime\":1573027367679,\"caseType\":1,\"id\":770,\"stuffType\":\"210\",\"url\":\"http://10.16.34.42:8080/group3/M00/0C/76/ChAiKlrMkHqAS2AXAAPpTv-WneE267.png\",\"zrReportNo\":\"ZR20190220002858\"}]");
        map.put("jtReportNo", "AJ20191106160248236186199");


        // 加密

//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure.t.ziroom.com/api/report/uploadBuJob";

        String resultContent = HttpRequestClient.postRequest(refundUrl, map);

        System.out.println(resultContent);

    }

}

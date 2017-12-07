package com.account.APITest;

import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.DesBase64Tool;

import java.util.HashMap;
import java.util.Map;

/**
 * 单元测试基类
 * 
 * @author liuxuming
 * 
 */
// XML风格
//@RunWith(SpringJUnit4ClassRunner.class)
/*@WebAppConfiguration(value = "src/main/webapp")*/
/*@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:applicationContext*.xml"),
		@ContextConfiguration(name = "child", locations = "classpath:rest-api.xml") })*/
public class BaseControllerWebAppContextSetupTest {

	//@Autowired
	//protected WebApplicationContext wac;
	//protected MockMvc mockMvc;

	// 密钥
    // 密钥
    protected final static String key = "8w091ql5l2tt6qxj3z0emh21";
    protected final static String key_ziroom = "8w091ql5l2tt6qxj";

    // 路径前缀
	protected static String path = "/account/";
	// 用户uid
	protected final String uid = "937d573a-4f25-638b-db9b-f97339e3e5ming-2";

	// 单元测试标记
	protected final static String TESTFALG = "单元测试";

	/**
	 * @Description: 加密算法选择
	 * @param @param jsonStr
	 * @param @param encryptionKey 传key 是 base64测试 传key_ziroom 是 AES加密测试
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author liuxm
	 * @date 2014年11月27日
	 */
	public Map<String, Object> encryptionWay(String jsonStr,
			String encryptionKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		String encryption = "";
		// 加密
		try {
			if (encryptionKey.equals(key)) {
				encryptionKey = "key   DesBase64Tool加密方式出现异常";
				encryption = DesBase64Tool.desEncrypt(jsonStr, key);
			} else {
				encryptionKey = "key_ziroom   CryptAES加密方式出现异常";
				encryption = CryptAES.AES_Encrypt(key_ziroom, jsonStr);
			}
			map.put("encryption", encryption);
			map.put("error", "");
			return map;
		} catch (Exception e) {
			map.put("error", encryptionKey + " 具体异常-----" + e);
			map.put("encryption", "");
			return map;
		}
	}

	/*@Before
	public void setUp() {
		DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders
				.webAppContextSetup(wac);
		// 增加过滤器
		defaultMockMvcBuilder.addFilters(new AccountSystemFilter());

		mockMvc = defaultMockMvcBuilder.build();
	}*/



}
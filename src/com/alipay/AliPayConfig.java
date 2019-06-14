package com.alipay;

import java.io.FileWriter;
import java.io.IOException;

public class AliPayConfig {



	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	        public static String app_id = "2016092800616922";

	        // 商户私钥，您的PKCS8格式RSA2私钥
	        public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC8jCmJzQYEGdyNmW0EfhpBKj41NCvTh9JYZwjHTsKmai7yCu3yiGlDmwEIY0EafXIRsE3hKGUg27EprWSb/BNSW8J5KvUZ+9ABel022x4SHxh+zp6DPPyjirfCNA60UGtn/gTSmyB7EHYVHG6gjEkqS4DY8jk2QYqPyjdjt7Cvyo07CHGbbGlGYLEdstHTHDKfPS5EWv7zB3hZ1OB+9nHhWQ2OdXOydpTxaiqe4oYLJRP0CBagJ0s1G6kp+pE2XgKsrnJcXZY6YA14dK0wQhDelO/EHQtrxoWnjt07I7VMSfpO1TSgzv4oixPe1iDEESQs3u1yd6C4Zzmp7CYS6ephAgMBAAECggEAHrbmfWA8vqZH23lG3Rh9xmfPQnOBQDA7/9KpB265HsrlYuCM6pl2LGEvxeIFVP9ieacyyJ7/+l5Pee6ZGR/zNdNk1sA8tULkG5mHXcxMFb+jCeU2xUJGFY4faS95xb3kAUjMGFLU87c2xTGgg97WfGFYV/79eu0qWUojw8bErZ4Vw1w2U6H4Qf1mvTo7K0EvmHUISanKSmDiwwFL+bLhYqGmKMFy2DAHVf44Y6oQtYIi4aIgpxdW3q2Cxo7jvcx34GHQAuEZhJDSa0TiEqoMgZ+iUxpRUDFKrjfZmqa8GO5ItLvlmW2QiOOPA9X7shvAl1fuyKgfuhSO/e/hCvC+EQKBgQDmMVVJf2mOiccC6WIc1BUUV8r+5FttfVUl4ePOKwsSlQ9ELB2C5BbAGjDDobgkIXDLHwdf8ib5zs3C59rscOid/BL4VjY5brL5vp76ARuXR8fzosljpcaYh7W1IDFApwkETr9bEi97VDw4UQMKLGA+PALLfBwyqMSbpPSPatVFMwKBgQDRr5ZXZlbInAuD8DELkqJWitwniokEXPhQQ9ucYAhD1GqSLLxf1nVT+hmxX+Z3BlCeTH1yEgq5zcniUvcEGGvC9Hm0a5s4Ni7HqYu3alPc90n2+yMEFJajL1N0M+CMoe99K2zKLcSVYNKmDB9BwKkQdA9+H6CTgutkUGJeGCnqGwKBgQDXw4QSuTfC4EfG5eUN6oi7obLnijpcfW7zbDFwTQ4647cEimk7B/p/I81zgcEtNJ8Z9UKfX0XDP2HEgDjHCOoxM1bAqWZ4HNfrmg4/fgxTl3fHWV11ZqyoygO6+6rO1AJypDFe9sPE0OcFToIP5hpsGynve6yem2x2C38kctnm2wKBgFdk+qFU2yjjuPz1uEtdg2HUoGuulusFoM07ayXi9K7osr5X/O9o4B/vJpRCJzlGnYVM1iAcGvJULiexcpj3YLqx0KP9EYW9N4QqSzxYCboYK3DQPUjvF9XN3Nea46VZvQqLdd1SdBPadhGVDdYG6bAc33Qu1GuG7nsx8b3MDnQvAoGAL2itWkLcMJ1lNK/RAWuBF/nJBK3b0kIxWpgPVCD+UN4wvL0SRkJxs/Lf2bnqSIxjX4IGWByxh/8jVr3jfeWBXv16WJ3oxKwTTX+JqOS8f5gH2/sSZKdkuJki3xCxFb+lpr2QHotlLQcmufljuWdtnrLhROK2Nu/EENktpwTsLTI=";

	        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApVSPI4T/nl0420uuu0U0w0pBhdSRKFjD9L59Wn89zfwA1/FPw5U6oITvCIojjQa/ogrE10lBosQsOdMKoV9oDXM62sewyJBc/IOnsFcld8cbwS4eNIHe7Jx1z6UDRR1E3KQ28x2OA8itfXEXV2z/oSyJ4YmG2Xwqf+XLDworhLE8lj/t3ig3GM8T8DAVE4rFNfAE/Hd7P67pXkHY1hcAuhcYiVp4sl4YLJM7rbN4mDn48DTy9Z3QCS8BGFtolvTtP7c7rnLgnFigOxuBRbjaAKrAxXGwqLnTxA5Nh2wYvWldZ9Es4iAFBL1YNt0xMcTQuewmJvvUZQRewygvFDW6TQIDAQAB";

	        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	        public static String notify_url = "http://ttms.time.com:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	        public static String return_url = "http://ttms.time.com:8080/TTMS/userIndex.jsp";

	        // 签名方式
	        public static String sign_type = "RSA2";

	        // 字符编码格式
	        public static String charset = "utf-8";

	        // 支付宝网关https://openapi.alipaydev.com/gateway.do
	        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	        // 支付宝网关
	        public static String log_path = "C:\\";


	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	        /**
	         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	         * @param sWord 要写入日志里的文本内容
	         */
	        public static void logResult(String sWord) {
	        FileWriter writer = null;
	        try {
	            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
	            writer.write(sWord);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (writer != null) {
	                try {
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}

package com.github.vspro.pay;

import com.alibaba.fastjson.JSON;
import com.github.vspro.pay.client.WxinPayClient;
import com.github.vspro.pay.client.wx.DefaultWxPayClient;
import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.exception.WxinPayException;
import com.github.vspro.pay.request.app.WxAppCloseOrderPayRequest;
import com.github.vspro.pay.request.app.WxAppOrderQueryPayRequest;
import com.github.vspro.pay.request.app.WxAppRefundQueryPayRequest;
import com.github.vspro.pay.request.app.WxAppUnifiedOrderPayRequest;
import com.github.vspro.pay.response.app.WxAppCloseOrderPayResponse;
import com.github.vspro.pay.response.app.WxAppOrderQueryPayResponse;
import com.github.vspro.pay.response.app.WxAppRefundQueryPayResponse;
import com.github.vspro.pay.response.app.WxAppUnifiedOrderPayResponse;
import org.junit.Test;

/**
 * APP支付测试
 */
public class WxAppPayTest {


    String appid = "***";
    String mchId = "**";
    String key = "*";


    /**
     * 统一下单
     * @throws WxinPayException
     */
    @Test
    public void appUnifiedOrderTest() throws WxinPayException {

        String notifyUrl = "http://xxxx.xx/pay/notify";
        WxinPayClient client = new DefaultWxPayClient(appid,  mchId, key);
        WxAppUnifiedOrderPayRequest request= new WxAppUnifiedOrderPayRequest();
        request.setBody("支付测试");
        request.setOutTradeNo("20191**************334");
        request.setFeeType("CNY");
        request.setTotalFee(1);
        request.setSpbillCreateIp("192.168.1.191");
        request.setNotifyUrl(notifyUrl);
        request.setTradeType("APP");
        request.setSignType(WxinPayConstants.SIGN_TYPE_MD5);
        WxAppUnifiedOrderPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));

    }

    /**
     * 订单查询
     * @throws WxinPayException
     */
    @Test
    public void appOrderQueryTest() throws WxinPayException{
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxAppOrderQueryPayRequest request = new WxAppOrderQueryPayRequest();
        request.setOutTradeNo("20191**************334");
        WxAppOrderQueryPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));

    }


    /**
     * 关闭订单
     */
    @Test
    public void appCloseOrderTest() throws WxinPayException {
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxAppCloseOrderPayRequest request = new WxAppCloseOrderPayRequest();
        request.setOutTradeNo("20191**************334");
        WxAppCloseOrderPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));
    }

    /**
     * 查询退款
     */
    @Test
    public void appRefundQueryTest() throws WxinPayException {
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxAppRefundQueryPayRequest request = new WxAppRefundQueryPayRequest();
        request.setOutTradeNo("20191**************334");
        WxAppRefundQueryPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));
    }

}

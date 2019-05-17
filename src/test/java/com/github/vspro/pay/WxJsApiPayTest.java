package com.github.vspro.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.github.vspro.pay.client.WxinPayClient;
import com.github.vspro.pay.client.wx.DefaultWxPayClient;
import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.exception.WxinPayException;
import com.github.vspro.pay.request.jsapi.WxJsApiCloseOrderPayRequest;
import com.github.vspro.pay.request.jsapi.WxJsApiOrderQueryPayRequest;
import com.github.vspro.pay.request.jsapi.WxJsApiRefundQueryPayRequest;
import com.github.vspro.pay.request.jsapi.WxJsApiUnifiedOrderPayRequest;
import com.github.vspro.pay.response.jsapi.WxJsApiCloseOrderPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiOrderQueryPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiRefundQueryPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiUnifiedOrderPayResponse;
import org.junit.Test;

/**
 * JSAPI测试
 */
public class WxJsApiPayTest {


    String appid = "***";
    String mchId = "**";
    String key = "*";


    /**
     * 统一下单
     * @throws WxinPayException
     */
    @Test
    public void jsApiUnifiedOrderTest() throws WxinPayException {

        String notifyUrl = "http://xxxx.xx/pay/notify";
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxJsApiUnifiedOrderPayRequest request= new WxJsApiUnifiedOrderPayRequest();
        request.setBody("支付测试");
        request.setOutTradeNo("20191************34");
        request.setFeeType("CNY");
        request.setTotalFee(1);
        request.setSpbillCreateIp("192.168.1.191");
        request.setNotifyUrl(notifyUrl);
        request.setTradeType("JSAPI");
        request.setSignType(WxinPayConstants.SIGN_TYPE_MD5);
        WxJsApiUnifiedOrderPayRequest.SceneInfo sceneInfo = new WxJsApiUnifiedOrderPayRequest.SceneInfo();
        WxJsApiUnifiedOrderPayRequest.StoreInfo storeInfo = new WxJsApiUnifiedOrderPayRequest.StoreInfo();
        storeInfo.setAddress("一路大厦");
        storeInfo.setAreaCode("440305");
        storeInfo.setName("大餐厅");
        storeInfo.setId("SZTX001");
        sceneInfo.setStoreInfo(storeInfo);
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        String json = JSON.toJSONString(sceneInfo, config);
        request.setSceneInfo(json);
        request.setOpenid("xxxxx");
        WxJsApiUnifiedOrderPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));

    }


    /**
     * 订单查询
     * @throws WxinPayException
     */
    @Test
    public void jsApiOrderQueryTest() throws WxinPayException{
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxJsApiOrderQueryPayRequest request = new WxJsApiOrderQueryPayRequest();
        request.setOutTradeNo("20191**************334");
        WxJsApiOrderQueryPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));

    }

    /**
     * 关闭订单
     */
    @Test
    public void jsApiCloseOrderTest() throws WxinPayException {
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxJsApiCloseOrderPayRequest request = new WxJsApiCloseOrderPayRequest();
        request.setOutTradeNo("20191**************334");
        WxJsApiCloseOrderPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));
    }

    /**
     * 查询退款
     */
    @Test
    public void jsApiRefundQueryTest() throws WxinPayException {
        WxinPayClient client = new DefaultWxPayClient(appid, mchId, key);
        WxJsApiRefundQueryPayRequest request = new WxJsApiRefundQueryPayRequest();
        request.setOutTradeNo("20191**************334");
        WxJsApiRefundQueryPayResponse resp = client.execute(request);
        System.out.println(JSON.toJSONString(resp));
    }
}

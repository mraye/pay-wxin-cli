package com.github.vspro.pay;

import com.alibaba.fastjson.JSON;
import com.github.vspro.pay.response.app.WxAppOrderQueryPayResponse;
import com.github.vspro.pay.response.app.WxAppRefundPayResponse;
import com.github.vspro.pay.response.app.WxAppRefundQueryPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiOrderQueryPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiRefundPayResponse;
import com.github.vspro.pay.response.jsapi.WxJsApiRefundQueryPayResponse;
import org.junit.Test;

public class XmlTest {



    @Test
    public void wxJsApiOrderQueryPayResponseTest (){
        String xml =
                "<xml>\n" +
                "  <coupon_count><![CDATA[1]]></coupon_count>\n" +
                "  <coupon_id_0><![CDATA[ds9fwiefw9fw9]]></coupon_id_0>\n" +
                "  <coupon_type_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0>\n" +
                "  <coupon_fee_0><![CDATA[345]]></coupon_fee_0>\n" +
                "</xml>";
        WxJsApiOrderQueryPayResponse resp = new WxJsApiOrderQueryPayResponse();
        resp.setCouponCount(1);
        resp.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(resp));
    }


    @Test
    public void wxJsApiRefundPayResponseTest(){
        String xml =
                "<xml>\n" +
                "  <coupon_refund_count><![CDATA[1]]></coupon_refund_count>\n" +
                "  <coupon_refund_id_0><![CDATA[0349034]]></coupon_refund_id_0>\n" +
                "  <coupon_type_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0>\n" +
                "  <coupon_refund_fee_0><![CDATA[43]]></coupon_refund_fee_0>\n" +
                "</xml>";

        WxJsApiRefundPayResponse resp = new WxJsApiRefundPayResponse();
        resp.setCouponRefundCount(1);
        resp.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void wxJsApiRefundQueryPayResponseTest(){
        String xml =
                "<xml>\n" +
                "  <out_refund_no_0><![CDATA[dlssd0f9sdklr2]]></out_refund_no_0>\n" +
                "  <refund_id_0><![CDATA[ds9fwiefw9fw9]]></refund_id_0>\n" +
                "  <refund_channel_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></refund_channel_0>\n" +
                "  <refund_fee_0><![CDATA[32]]></refund_fee_0>\n" +
                "  <coupon_refund_fee_0><![CDATA[2]]></coupon_refund_fee_0>\n" +
                "  <coupon_refund_count_0><![CDATA[2]]></coupon_refund_count_0>\n" +
                "  <refund_status_0><![CDATA[2019141715235353515534]]></refund_status_0>\n" +
                "  <refund_account_0><![CDATA[CNY]]></refund_account_0>\n" +
                "  <refund_recv_accout_0><![CDATA[1]]></refund_recv_accout_0>\n" +
                "  <coupon_refund_id_0_0><![CDATA[9430490390]]></coupon_refund_id_0_0>\n" +
                "  <coupon_type_0_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0_0>\n" +
                "  <coupon_refund_fee_0_0><![CDATA[1]]></coupon_refund_fee_0_0>\n" +
                "  <coupon_refund_id_0_1><![CDATA[324]]></coupon_refund_id_0_1>\n" +
                "  <coupon_type_0_1><![CDATA[3423]]></coupon_type_0_1>\n" +
                "  <coupon_refund_fee_0_1><![CDATA[2]]></coupon_refund_fee_0_1>\n" +
                "</xml>";
        WxJsApiRefundQueryPayResponse response = new WxJsApiRefundQueryPayResponse();
        response.setRefundCount(0);
        response.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void wxAppRefundQueryPayResponseTest(){
        String xml =
                "<xml>\n" +
                "  <out_refund_no_0><![CDATA[dlssd0f9sdklr2]]></out_refund_no_0>\n" +
                "  <refund_id_0><![CDATA[23423]]></refund_id_0>\n" +
                "  <refund_channel_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></refund_channel_0>\n" +
                "  <refund_fee_0><![CDATA[32]]></refund_fee_0>\n" +
                "  <coupon_refund_fee_0><![CDATA[2]]></coupon_refund_fee_0>\n" +
                "  <coupon_refund_count_0><![CDATA[2]]></coupon_refund_count_0>\n" +
                "  <refund_status_0><![CDATA[2019141715235353515534]]></refund_status_0>\n" +
                "  <refund_account_0><![CDATA[CNY]]></refund_account_0>\n" +
                "  <refund_recv_accout_0><![CDATA[1]]></refund_recv_accout_0>\n" +
                "  <coupon_refund_id_0_0><![CDATA[3454353]]></coupon_refund_id_0_0>\n" +
                "  <coupon_type_0_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0_0>\n" +
                "  <coupon_refund_fee_0_0><![CDATA[1]]></coupon_refund_fee_0_0>\n" +
                "  <coupon_refund_id_0_1><![CDATA[324]]></coupon_refund_id_0_1>\n" +
                "  <coupon_type_0_1><![CDATA[3423]]></coupon_type_0_1>\n" +
                "  <coupon_refund_fee_0_1><![CDATA[2]]></coupon_refund_fee_0_1>\n" +
                "</xml>";
        WxAppRefundQueryPayResponse response = new WxAppRefundQueryPayResponse();
        response.setRefundCount(1);
        response.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(response));
    }


    @Test
    public void wxAppRefundPayResponseTest(){
        String xml =
                "<xml>\n" +
                "  <coupon_refund_count><![CDATA[1]]></coupon_refund_count>\n" +
                "  <coupon_refund_id_0><![CDATA[2394892]]></coupon_refund_id_0>\n" +
                "  <coupon_type_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0>\n" +
                "  <coupon_refund_fee_0><![CDATA[43]]></coupon_refund_fee_0>\n" +
                "</xml>";

        WxAppRefundPayResponse resp = new WxAppRefundPayResponse();
        resp.setCouponRefundCount(1);
        resp.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(resp));
    }

    @Test
    public void wxAppOrderQueryPayResponseTest(){
        String xml =
                "<xml>\n" +
                "  <coupon_count><![CDATA[1]]></coupon_count>\n" +
                "  <coupon_id_0><![CDATA[werwqefwa]]></coupon_id_0>\n" +
                "  <coupon_type_0><![CDATA[fff3026fea4e496d9d9e08465075e7b0]]></coupon_type_0>\n" +
                "  <coupon_fee_0><![CDATA[345]]></coupon_fee_0>\n" +
                "</xml>";

        WxAppOrderQueryPayResponse resp = new WxAppOrderQueryPayResponse();
        resp.setCouponCount(1);
        resp.postProcessAfterResponse(xml);
        System.out.println(JSON.toJSONString(resp));
    }
}

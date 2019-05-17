package com.github.vspro.pay.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;


@Data
public abstract class BaseWxPayResponse implements Serializable {

    private String appid;

    @XStreamAlias("mch_id")
    private String mchId;

    @XStreamAlias("nonce_str")
    private String nonceStr;

    private String sign;

    @XStreamAlias("result_code")
    private String resultCode;

    @XStreamAlias("err_code")
    private String errCode;

    @XStreamAlias("err_code_des")
    private String errCodeDes;

    @XStreamAlias("return_code")
    private String returnCode;

    @XStreamAlias("return_msg")
    private String returnMsg;

    private String rawResponse;


    protected Document getDocument(String xml){
        try {
            SAXReader reader = new SAXReader();
            Document document =  reader.read(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
            return document;

        } catch (DocumentException e) {
            throw new RuntimeException("xml解析异常", e);
        }
    }


}

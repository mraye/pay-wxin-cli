package com.github.vspro.pay.client.wx;

import com.github.vspro.pay.client.WxRequestHolder;
import com.github.vspro.pay.client.WxinPayClient;
import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.exception.WxinPayException;
import com.github.vspro.pay.postprocessor.WxResponsePostProcessor;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.BaseWxPayResponse;
import com.github.vspro.pay.signer.WxSigner;
import com.github.vspro.pay.util.WebUtils;
import com.github.vspro.pay.util.WxSignatureUtil;
import com.github.vspro.pay.util.WxXmlUtil;
import lombok.Data;

import java.io.IOException;
import java.util.UUID;

@Data
public abstract class AbstractWxPayClient implements WxinPayClient {


    //公众账号ID
    private String appId;
    //商户号
    private String mchId;
    //微信密钥
    private String key;
    // 沙箱或者是正式环境(默认是正式)
    private String gateWay;
    private String signType = WxinPayConstants.SIGN_TYPE_MD5;
    private String charset = WxinPayConstants.CHARSET;
    private int readTimeout = 3000;
    private int writeTimeout = 5000;

    public AbstractWxPayClient(String appId, String mchId, String key) {
        this(appId, mchId, key, WxinPayConstants._DOMAIN);
    }

    public AbstractWxPayClient(String appId, String mchId, String key, String gateWay) {
        this.appId = appId;
        this.mchId = mchId;
        this.key = key;
        this.gateWay = gateWay;
    }

    @Override
    public <T extends BaseWxPayResponse> T execute(BaseWxPayRequest<T> request) throws WxinPayException {

        try {
            request.setNonceStr(UUID.randomUUID().toString().replaceAll("-", ""));
            request.setAppid(getAppId());
            request.setMchId(getMchId());
            WxRequestHolder holder = new WxRequestHolder(request);
            String sign = getSinger().sign(WxSignatureUtil.getSignContent(holder, key), signType);
            request.setSign(sign);
            String xml = WxXmlUtil.toXml(request);
            System.out.println("xml: \n" + xml);
            String result = WebUtils.doPost(getGateWay() + request.getUrl(), xml, charset, writeTimeout, readTimeout);
            System.out.println("resp: \n" + result);
            T resp = WxXmlUtil.toBean(result, request.getResponseClass());
            if (resp instanceof WxResponsePostProcessor) {
                ((WxResponsePostProcessor)resp).postProcessAfterResponse(result);
            }
            return resp;
        } catch (IOException | IllegalAccessException e) {
            throw new WxinPayException(e);
        }
    }


    protected abstract WxSigner getSinger();
}

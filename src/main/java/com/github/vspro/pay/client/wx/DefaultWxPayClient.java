package com.github.vspro.pay.client.wx;

import com.github.vspro.pay.signer.DefaultWxSigner;
import com.github.vspro.pay.signer.WxSigner;
import lombok.Data;

/**
 * 默认微信支付client
 */
@Data
public class DefaultWxPayClient extends AbstractWxPayClient {

    private WxSigner signer;

    public DefaultWxPayClient(String appId, String mchId, String key) {
        super(appId, mchId, key);
        this.signer = new DefaultWxSigner();
    }

    @Override
    protected WxSigner getSinger() {
        return signer;
    }

    public static class Builder {

        private DefaultWxPayClient client;


        public Builder(String appId, String mchId, String key){
            this.client = new DefaultWxPayClient(appId, mchId, key);
        }

        public Builder gateWay(String gateWay) {
            this.client.setGateWay(gateWay);
            return this;
        }

        public Builder signType(String signType) {
            this.client.setSignType(signType);
            return this;
        }

        public Builder signer(WxSigner signer) {
            this.client.setSigner(signer);
            return this;
        }

        public Builder charset(String charset) {
            this.client.setCharset(charset);
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            this.client.setReadTimeout(readTimeout);
            return this;
        }

        public Builder writeTimeout(int writeTimeout) {
            this.client.setWriteTimeout(writeTimeout);
            return this;
        }

        public DefaultWxPayClient build(){
            return client;
        }
    }


}

package com.github.vspro.pay.signer;

import com.github.vspro.pay.constants.WxinPayConstants;
import com.github.vspro.pay.exception.WxinPayException;
import com.github.vspro.pay.util.WxSignatureUtil;

/**
 * 默认MD5签名
 */
public class DefaultWxSigner implements WxSigner {


    private static final String SIGN_TYPE = WxinPayConstants.SIGN_TYPE_MD5;


    @Override
    public String sign(String source, String type) throws WxinPayException {

        if (!SIGN_TYPE.equals(type)){
            throw new WxinPayException("不支持的签名方式!!");
        }

        return WxSignatureUtil.sign(source, type);
    }

}

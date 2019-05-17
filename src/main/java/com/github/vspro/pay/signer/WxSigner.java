package com.github.vspro.pay.signer;

import com.github.vspro.pay.exception.WxinPayException;

/**
 * 签名方式
 */
public interface WxSigner {

    String sign(String source, String type) throws WxinPayException;

}

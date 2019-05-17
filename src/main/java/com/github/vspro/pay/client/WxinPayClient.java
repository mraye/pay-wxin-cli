package com.github.vspro.pay.client;

import com.github.vspro.pay.exception.WxinPayException;
import com.github.vspro.pay.request.BaseWxPayRequest;
import com.github.vspro.pay.response.BaseWxPayResponse;

public interface WxinPayClient {

    <T extends BaseWxPayResponse> T execute(BaseWxPayRequest<T> request) throws WxinPayException;

}

package com.github.vspro.pay.postprocessor;


/**
 * 对返回结果的xml作进一步处理[主要是对xml中有list时处理]
 */
public interface WxResponsePostProcessor {

    void postProcessAfterResponse(String xml);

}

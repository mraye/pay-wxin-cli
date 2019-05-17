package com.github.vspro.pay.response.app;

import com.github.vspro.pay.postprocessor.WxResponsePostProcessor;
import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询订单 Response
 */
@Data
public class WxAppOrderQueryPayResponse extends BaseWxPayResponse implements WxResponsePostProcessor {


    @XStreamAlias("device_info")
    private String deviceInfo;

    private String openid;

    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAlias("trade_state")
    private String tradeState;

    @XStreamAlias("bank_type")
    private String bankType;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAlias("cash_fee")
    private Integer cashFee;

    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;

    @XStreamAlias("coupon_fee")
    private Integer couponFee;

    @XStreamAlias("coupon_count")
    private Integer couponCount;

    /**
     * 代金券列表
     */
    private List<Coupon> coupons;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    private String attach;

    @XStreamAlias("time_end")
    private String timeEnd;

    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;

//    @XStreamAlias("coupon_id_$n")
//    private String couponId$n;
//
//    @XStreamAlias("coupon_type_$n")
//    private String couponType$n;
//
//    @XStreamAlias("coupon_fee_$n")
//    private String couponFee$n;


    @Data
    @AllArgsConstructor
    class Coupon implements Serializable {

        private String couponId;

        private String couponType;

        private Integer couponFee;

    }


    @Override
    public void postProcessAfterResponse(String xml) {

        if (null != couponCount && this.couponCount > 0) {
            Document document = getDocument(xml);
            Element root = document.getRootElement();
            this.coupons = new ArrayList<>();
            for (int i = 0; i < this.couponCount; i++) {
                this.coupons
                        .add(new Coupon(root.elementTextTrim("coupon_id_" + i),
                                root.elementTextTrim("coupon_type_" + i),
                                Integer.valueOf(root.elementTextTrim("coupon_fee_" + i))));
            }

        }

    }
}

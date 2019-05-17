package com.github.vspro.pay.response.app;

import com.github.vspro.pay.postprocessor.WxResponsePostProcessor;
import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请退款 Response
 */
@Data
public class WxAppRefundPayResponse extends BaseWxPayResponse implements WxResponsePostProcessor {


    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("out_refund_no")
    private String outRefundNo;

    @XStreamAlias("refund_id")
    private String refundId;

    @XStreamAlias("refund_fee")
    private Integer refundFee;

    @XStreamAlias("settlement_refund_fee")
    private Integer settlementRefundFee;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;

    @XStreamAlias("fee_type")
    private String feeType;

    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    @XStreamAlias("cash_refund_fee")
    private Integer cashRefundFee;

    @XStreamAlias("coupon_refund_fee")
    private Integer couponRefundFee;

    @XStreamAlias("coupon_refund_count")
    private Integer couponRefundCount;

    private List<CouponRefund> couponRefunds;


    @AllArgsConstructor
    @Data
    private class CouponRefund {

        private String couponRefundId;

        private String couponType;

        private Integer couponRefundFee;

    }

    @Override
    public void postProcessAfterResponse(String xml) {

        if (null != this.couponRefundCount && this.couponRefundCount > 0) {
            Document document = getDocument(xml);
            Element root = document.getRootElement();
            this.couponRefunds = new ArrayList<>();
            for (int i = 0; i < this.couponRefundCount; i++) {
                this.couponRefunds
                        .add(new CouponRefund(
                                root.elementTextTrim("coupon_refund_id_" + i),
                                root.elementTextTrim("coupon_type_" + i),
                                Integer.valueOf(root.elementTextTrim("coupon_refund_fee_" + i)))
                        );
            }
        }
    }

}

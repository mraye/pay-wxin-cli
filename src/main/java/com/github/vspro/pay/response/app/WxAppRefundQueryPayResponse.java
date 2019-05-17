package com.github.vspro.pay.response.app;

import com.github.vspro.pay.postprocessor.WxResponsePostProcessor;
import com.github.vspro.pay.response.BaseWxPayResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 查询退款 Response
 */
@Data
public class WxAppRefundQueryPayResponse extends BaseWxPayResponse implements WxResponsePostProcessor {


    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("total_refund_count")
    private Integer totalRefundCount;

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

    @XStreamAlias("refund_count")
    private Integer refundCount;

    private List<Refund> refunds;


    @Data
    @AllArgsConstructor
    private class Refund {

        private String outRefundNo;

        private String refundId;

        private String refundChannel;

        private Integer refundFee;

        private Integer couponRefundFee;

        private String refundStatus;

        private String refundAccount;

        private String refundRecvAccout;

        private String refundSuccessTime;

        private Integer couponRefundCount;

        private List<CouponRefund> couponRefunds;


    }

    @Data
    @AllArgsConstructor
    private class CouponRefund {

        private String couponRefundId;

        private String couponType;

        private Integer couponRefundFee;
    }

    @Override
    public void postProcessAfterResponse(String xml) {

        if (null != refundCount && this.refundCount > 0) {

            this.refunds = new ArrayList<>();
            Document document = getDocument(xml);
            Element root = document.getRootElement();
            IntStream.range(0, this.refundCount).forEach(i -> {

                Refund refund = new Refund(
                        root.elementTextTrim("out_refund_no_" + i),
                        root.elementTextTrim("refund_id_" + i),
                        root.elementTextTrim("refund_channel_" + i),
                        getIntValue(root.elementTextTrim("refund_fee_" + i)),
                        getIntValue(root.elementTextTrim("coupon_refund_fee_" + i)),
                        root.elementTextTrim("refund_status_" + i),
                        root.elementTextTrim("refund_account_" + i),
                        root.elementTextTrim("refund_recv_accout_" + i),
                        root.elementTextTrim("refund_success_time_" + i),
                        getIntValue(root.elementTextTrim("coupon_refund_count_" + i)),
                        Collections.EMPTY_LIST
                );


                String couponRefundCount = root.elementTextTrim("coupon_refund_count_" + i);
                if (null != couponRefundCount && !"".equals(couponRefundCount)) {

                    int crfc = getIntValue(couponRefundCount);
                    if (crfc > 0) {
                        final List<CouponRefund> couponRefunds = new ArrayList<>();

                        IntStream.range(0, crfc).forEach(j -> {
                            CouponRefund couponRefund = new CouponRefund(
                                    root.elementTextTrim("coupon_refund_id_" + i + "_" + j),
                                    root.elementTextTrim("coupon_type_" + i + "_" + j),
                                    getIntValue(root.elementTextTrim("coupon_refund_fee_" + i + "_" + j))
                            );

                            couponRefunds.add(couponRefund);
                        });
                        refund.setCouponRefunds(couponRefunds);
                    }
                }

                this.refunds.add(refund);

            });
        }


    }

    private int getIntValue(String value) {
        if (null == value || "".equals(value)) {
            return 0;
        }
        return Integer.valueOf(value);
    }

}

package lottery.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 系统常量定义类
 * 
 * @author 沈时宇
 * @version 1.0
 * @date 2025/7/22
 */
public class Constants {

    /**
     * 响应码
     */
    @Getter
    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        INDEX_DUP("0003", "主键冲突");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

    }


    /**
     * 策略模式
     */
    @Getter
    public enum StrategyMode {


        SINGLE(1, "单项概率"),
        ENTIRETY(2, "总体概率");

        private Integer code;
        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }

    /**
     * 中奖状态
     */
    @Getter
    public enum DrawState {

        FAIL(0, "未中奖"),
        SUCCESS(1, "已中奖"),
        COVER(2, "兜底奖");

        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }
    /**
     * 发奖状态，0：等待发奖，1：发奖成功，2：发奖失败
     */
    @Getter
    public enum AwardState {

        WAIT(0, "等待发奖"),
        SUCCESS(1, "发奖成功"),
        FAIL(2, "发奖失败");

        private Integer code;
        private String info;
        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }

    /**
     * 奖品类型
     */
    @Getter
    public enum AwardType {

        DESC(1, "文字描述"),
        RedeemCodeGoods(2, "兑换码"),
        CouponGoods(3, "优惠券"),
        PhysicalGoods(4, "实物奖品");

        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }
}

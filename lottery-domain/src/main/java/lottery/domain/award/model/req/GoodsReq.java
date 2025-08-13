package lottery.domain.award.model.req;

import lombok.*;
import lottery.domain.award.model.vo.ShippingAddress;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/11
 * @description
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsReq {
    /**
     * 用户id
     */
    private String uId;

    /**
     * 抽奖单号id
     */
    private String orderId;

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容
     */
    private String awardContent;

    /**
     * 四级送货地址(只有实物类商品需要地址）
     */
    private ShippingAddress shippingAddress;

    /**
     * 额外信息
     */
    private String extInfo;

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent, ShippingAddress shippingAddress) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
    }
}


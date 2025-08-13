package lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/8
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrawAwardInfo {
    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品种类(1.文字描述 2、兑换码 3、优惠券 4、实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容（sku、描述、奖品码）
     */
    private String awardContent;

}

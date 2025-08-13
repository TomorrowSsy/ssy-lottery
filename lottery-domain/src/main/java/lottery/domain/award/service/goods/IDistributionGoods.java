package lottery.domain.award.service.goods;

import lottery.domain.award.model.req.GoodsReq;
import lottery.domain.award.model.res.DistributionRes;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/11
 * @description
 */
public interface IDistributionGoods {
    /**
     * 奖品配送接口，奖品类型（1、文字描述 2、兑换码 3、优惠券 4、实物奖品）
     * @param req
     * @return
     */
    DistributionRes doDistribution(GoodsReq req);

    Integer getDistributionName();



}

package lottery.domain.award.service.goods.impl;

import lottery.common.Constants;
import lottery.domain.award.model.req.GoodsReq;
import lottery.domain.award.model.res.DistributionRes;
import lottery.domain.award.service.goods.DistributionBase;
import lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/12
 * @description
 */
@Component
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // 模拟调用兑换码
        logger.info("模拟调用兑换码 uid: {}, awardContent: {}", req.getUId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return DistributionRes.builder()
                .uId(req.getUId())
                .code(Constants.AwardState.SUCCESS.getCode())
                .info(Constants.AwardState.SUCCESS.getInfo()).build();
    }

    @Override
    public Integer getDistributionName() {
        return Constants.AwardType.RedeemCodeGoods.getCode();
    }
}

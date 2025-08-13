package lottery.domain.award.service.factory;

import lottery.common.Constants;
import lottery.domain.award.service.goods.IDistributionGoods;
import lottery.domain.award.service.goods.impl.CouponGoods;
import lottery.domain.award.service.goods.impl.DescGoods;
import lottery.domain.award.service.goods.impl.PhysicalGoods;
import lottery.domain.award.service.goods.impl.RedeemCodeGoods;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/12
 * @description
 */
public class GoodsConfig {
    /**
     * 奖品发放策略奖
     */
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private DescGoods descGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }
}

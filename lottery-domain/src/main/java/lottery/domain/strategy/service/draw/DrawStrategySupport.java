package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.repository.IStrategyRepository;
import lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/8
 * @description 抽奖策略数据支撑，一些通用的数据服务
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略的详细配置信息
     * @param strategyId
     * @return
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询
     * @param awardId
     * @return
     */
    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}

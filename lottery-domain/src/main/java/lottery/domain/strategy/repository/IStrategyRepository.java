package lottery.domain.strategy.repository;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.infrastructure.po.Award;

/**
 * 策略表仓储服务
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 * @description
 */
public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);


}

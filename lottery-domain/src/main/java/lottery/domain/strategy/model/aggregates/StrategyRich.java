package lottery.domain.strategy.model.aggregates;

import lottery.infrastructure.po.Strategy;
import lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 * @description
 */
public class StrategyRich {

    private Long strategyId;
    private Strategy strategy;
    private List<StrategyDetail> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }
}

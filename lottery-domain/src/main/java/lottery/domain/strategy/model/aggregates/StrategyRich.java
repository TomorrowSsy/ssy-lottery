package lottery.domain.strategy.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lottery.infrastructure.po.Strategy;
import lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyRich {


    private Long strategyId;
    private Strategy strategy;
    private List<StrategyDetail> strategyDetailList;

}

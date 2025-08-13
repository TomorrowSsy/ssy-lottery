package lottery.domain.strategy.repository.impl;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.repository.IStrategyRepository;
import lottery.infrastructure.dao.IAwardDao;
import lottery.infrastructure.dao.IStrategyDao;
import lottery.infrastructure.dao.IStrategyDetailDao;
import lottery.infrastructure.po.Award;
import lottery.infrastructure.po.Strategy;
import lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/7
 * @description
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);

    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        return strategyDetailDao.deductStock(req) == 1;
    }
}

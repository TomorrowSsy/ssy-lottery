package lottery.domain.strategy.service.draw.impl;


import com.alibaba.fastjson.JSON;
import lottery.domain.strategy.model.res.DrawResult;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.domain.strategy.service.draw.AbstractDrawBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.plaf.TextUI;
import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/8
 * @description
 */
@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIdList) {
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIdList);
        if (awardId == null) {
            return null;
        }
        /*
         * 扣减库存，现在是数据库行锁扣减，之后优化为redis
         * 知识点：正常情况的分库分表情况下的个人数据记录可以用行级锁，因为只影响个人数据，不会影响他人数据
         */
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        return isSuccess ? awardId : null;
    }

    @Override
    public List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> excludeAwardList = strategyRepository.queryNoStockAwardList(strategyId);
        logger.info("执行抽奖策略：{}, 无库存的奖品list为：{}", strategyId, JSON.toJSONString(excludeAwardList));
        return excludeAwardList;


    }
}

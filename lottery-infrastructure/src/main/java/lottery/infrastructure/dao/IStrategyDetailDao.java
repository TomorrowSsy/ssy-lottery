package lottery.infrastructure.dao;

import lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/7
 * @description
 */
@Mapper
public interface IStrategyDetailDao {
    /**
     * 查询策略表详细配置
     * @param strategyId 策略id
     * @return
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 查询策略中已经无库存的奖品id
     * @param strategyId
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyDetailReq
     * @return
     */
    int deductStock(StrategyDetail strategyDetailReq);
}

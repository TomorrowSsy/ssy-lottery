package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
public class DrawBase extends DrawConfig {
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (strategyMode != 1) {
            return;
        }
        IDrawAlgorithm iDrawAlgorithm = super.drawAlgorithmMap.get(strategyMode);
        Boolean existRateTuple = iDrawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());

        for (StrategyDetail strategyDetail: strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        iDrawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}

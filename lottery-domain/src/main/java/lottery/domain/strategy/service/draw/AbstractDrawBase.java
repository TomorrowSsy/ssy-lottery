package lottery.domain.strategy.service.draw;

import lottery.common.Constants;
import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.model.req.DrawReq;
import lottery.domain.strategy.model.res.DrawResult;
import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.model.vo.DrawAwardInfo;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.infrastructure.po.Award;
import lottery.infrastructure.po.Strategy;
import lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * 抽象抽奖过程，模版模式？
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    private final Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);


    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 获取策略
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        // 初始化抽奖tuple
        this.checkAndInitRateData(strategy.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 查询不在抽奖范围的奖品
        List<String> excludeAwardIdList = queryExcludeAwardIds(strategy.getStrategyId());

        // 抽奖
        String awardId = this.drawAlgorithm(strategy.getStrategyId(), super.drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIdList);

        // 包装中奖结果
        return buildDrawResult(req.getuId(), req.getStrategyId(), awardId);
    }

    public DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (awardId == null) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return DrawResult.builder().uId(uId).strategyId(strategyId).drawState(Constants.DrawState.FAIL.getCode()).build();
        }

        Award awardInfo = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = DrawAwardInfo.builder()
                .awardId(awardId)
                .awardName(awardInfo.getAwardName())
                .awardContent(awardInfo.getAwardContent())
                .awardType(awardInfo.getAwardType())
                .build();
        logger.info("执行策略抽奖完成【已中奖】，用户: {}, 策略id: {}, 奖品id: {}, 奖品名称: {}", uId, strategyId, awardId, awardInfo.getAwardName());

        return DrawResult.builder().uId(uId).
                strategyId(strategyId).
                drawState(Constants.DrawState.SUCCESS.getCode()).
                drawAwardInfo(drawAwardInfo).build();

    }


    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIdList);

    public abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 检测抽奖策略是否已经初始化
     * @param strategyId
     * @param strategyMode
     * @param strategyDetailList
     */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        // 非单项概率，不用存入缓存
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }
        IDrawAlgorithm iDrawAlgorithm = super.drawAlgorithmMap.get(strategyMode);

        if (iDrawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());

        for (StrategyDetail strategyDetail: strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        iDrawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}

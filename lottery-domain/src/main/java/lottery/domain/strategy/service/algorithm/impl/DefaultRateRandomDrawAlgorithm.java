package lottery.domain.strategy.service.algorithm.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardsIds) {
        BigDecimal differenceDenominator =  BigDecimal.ZERO;

        List<AwardRateInfo> differenceAwardsIds = new ArrayList<>();
        List<AwardRateInfo> awardsRateInfos = super.awardRateInfoMap.get(strategyId);

        // 找到所有可被抽取的奖品
        for (AwardRateInfo awardRateInfo: awardsRateInfos) {
            String awardsId = awardRateInfo.getAwardId();
            if (excludeAwardsIds.contains(awardsId)) {
                continue;
            }
            differenceAwardsIds.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        if (differenceAwardsIds.isEmpty()) {
            return "未中奖";
        }

        int randomVal = new SecureRandom().nextInt(100) + 1;
        int cursor = 0;
        for (AwardRateInfo awardRateInfo: differenceAwardsIds) {
            int rate = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, RoundingMode.UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= cursor + rate) {
                return awardRateInfo.getAwardId();
            }
            cursor += rate;
        }
        return "";
    }
}

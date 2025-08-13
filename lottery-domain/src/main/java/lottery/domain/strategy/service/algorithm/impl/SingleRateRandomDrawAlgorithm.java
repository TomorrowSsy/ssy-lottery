package lottery.domain.strategy.service.algorithm.impl;

import com.sun.deploy.ui.AboutDialog;
import lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
@Component
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardsIds) {
        // 获取概率数组
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        if (rateTuple == null) {
            throw new RuntimeException("不存在strategyId对用的rateTuple数组");
        }

        // 0~100随机数
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);

        // 获取中奖信息并返回
        String awardsId = rateTuple[idx];
        if (excludeAwardsIds.contains(awardsId)) {
            return "未中奖";
        }
        return awardsId;
    }

}

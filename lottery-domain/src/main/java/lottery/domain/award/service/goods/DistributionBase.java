package lottery.domain.award.service.goods;

import lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/11
 * @description
 */
public class DistributionBase {
    protected final Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO: 2025/8/11  
    }
}

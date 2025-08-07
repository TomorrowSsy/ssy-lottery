package lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * 奖品概率信息，奖品概率、编号、库存
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/5
 */
public class AwardRateInfo {
    // 奖品id
    private String awardId;

    // 中奖概率
    private BigDecimal awardRate;

    public AwardRateInfo() {

    }


    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}

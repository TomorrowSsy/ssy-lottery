package lottery.domain.strategy.model.res;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
public class DrawResult {
    // 用户id
    private String uId;
    // 策略id
    private Long strategyId;
    // 奖品id
    private String awardId;
    // 奖品名称
    private String awardName;

    public DrawResult() {

    }

    public DrawResult(String uId, Long strategyId, String awardId, String awardName) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}

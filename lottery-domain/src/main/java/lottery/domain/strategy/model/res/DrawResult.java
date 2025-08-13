package lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lottery.common.Constants;
import lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class DrawResult {
    /**
     * 用户id
     */
    private String uId;
    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 中奖状态, 0:未中奖, 1:已中奖
     */
    private Integer drawState;

    private DrawAwardInfo drawAwardInfo;


}

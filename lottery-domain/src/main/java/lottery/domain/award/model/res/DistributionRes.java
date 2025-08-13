package lottery.domain.award.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/11
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistributionRes {
    /**
     * 用户id
     */
    private String uId;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述
     */
    private String info;

    /**
     * 结算单id，发券后有券码、发货后有单号，用于存根查询
     */
    private String statementId;

    public DistributionRes(String uId , Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;

    }
}

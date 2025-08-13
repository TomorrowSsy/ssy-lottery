package lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Award {
    private Long id;
    private Long awardId;
    private Integer awardType;
    private Integer awardCount;
    private String awardName;
    private String awardContent;
    private Date createTime;
    private Date updateTime;


}

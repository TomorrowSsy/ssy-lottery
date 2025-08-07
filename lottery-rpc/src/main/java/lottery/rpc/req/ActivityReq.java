package lottery.rpc.req;

import java.io.Serializable;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/7/22
 */
public class ActivityReq implements Serializable {

    private Long ActivityId;

    public void setActivityId(Long activityId) {
        ActivityId = activityId;
    }

    public Long getActivityId() {
        return ActivityId;
    }
}

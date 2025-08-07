package lottery.rpc.res;

import lottery.common.Result;
import lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/7/22
 */
public class ActivityRes implements Serializable {

    private ActivityDto activityDto;

    private Result result;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(ActivityDto activityDto, Result result) {
        this.activityDto = activityDto;
        this.result = result;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

package lottery.common;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/7/22
 */
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = -3826891916021780628L;

    private String code;
    private String info;


    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public Result buildSuccessResult() {
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public Result buildErrorResult() {
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }


}

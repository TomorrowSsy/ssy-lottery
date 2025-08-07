package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.model.req.DrawReq;
import lottery.domain.strategy.model.res.DrawResult;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);
}

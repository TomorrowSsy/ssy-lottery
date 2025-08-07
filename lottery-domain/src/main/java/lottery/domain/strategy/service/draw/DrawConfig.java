package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.domain.strategy.service.algorithm.impl.DefaultRateRandomDrawAlgorithm;
import org.apache.ibatis.annotations.Result;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/6
 */
public class DrawConfig {

    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void initial() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }

}

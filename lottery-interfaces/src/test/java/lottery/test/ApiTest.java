package lottery.test;

import com.alibaba.fastjson.JSON;
import lottery.common.Constants;
import lottery.domain.award.model.req.GoodsReq;
import lottery.domain.award.model.res.DistributionRes;
import lottery.domain.award.service.factory.DistributionGoodsFactory;
import lottery.domain.award.service.goods.IDistributionGoods;
import lottery.domain.strategy.model.req.DrawReq;
import lottery.domain.strategy.model.res.DrawResult;
import lottery.domain.strategy.model.vo.DrawAwardInfo;
import lottery.domain.strategy.service.draw.impl.DrawExecImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/8
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Resource
    private DrawExecImpl drawExec;
    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawReq("王强", 100001L));
        drawExec.doDrawExec(new DrawReq("李秋豪", 100001L));
        drawExec.doDrawExec(new DrawReq("沈时宇", 100001L));
        drawExec.doDrawExec(new DrawReq("钟正", 100001L));
    }

    @Test
    public void test_drawAndDistribution() {
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("ssy", 10001L));
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("未中奖");
            return;
        }
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = GoodsReq.builder()
                .uId(drawResult.getUId()).orderId("1234")
                .awardId(drawAwardInfo.getAwardId())
                .awardName(drawAwardInfo.getAwardName())
                .awardContent(drawAwardInfo.getAwardContent())
                .build();
        // 根据awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);
        logger.info("测试结果： {}", JSON.toJSONString(distributionRes));
    }
}

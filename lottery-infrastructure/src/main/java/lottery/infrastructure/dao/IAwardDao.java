package lottery.infrastructure.dao;

import lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/7
 * @description
 */
@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}

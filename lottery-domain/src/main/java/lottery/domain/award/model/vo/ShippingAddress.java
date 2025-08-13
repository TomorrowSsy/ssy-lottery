package lottery.domain.award.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 沈时宇
 * @version 1.0
 * @date 2025/8/11
 * @description
 */
@Getter
@Setter
public class ShippingAddress {
    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 一级地址id
     */
    private String provinceId;

    /**
     * 一级地址名称
     */
    private String provinceName;

    /**
     * 二级地址id
     */
    private String cityId;

    /**
     * 二级地址名称
     */
    private String cityName;

    /**
     * 三级地址id
     */
    private String countyId;

    /**
     * 三级地址名称
     */
    private String countyName;

    /**
     * 四级地址id
     */
    private String townId;

    /**
     * 四级地址名称
     */
    private String townName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;
}

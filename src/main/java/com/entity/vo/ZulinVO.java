package com.entity.vo;

import com.entity.ZulinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 租赁模块
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-20
 */
@TableName("zulin")
public class ZulinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车辆信息
     */

    @TableField(value = "cl_types")
    private Integer clTypes;


    /**
     * 租车用户
     */

    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 租赁期限
     */

    @TableField(value = "day")
    private Integer day;


    /**
     * 是否签订合同 Search
     */

    @TableField(value = "sf_types")
    private Integer sfTypes;


    /**
     * 总价格
     */

    @TableField(value = "maxmoney")
    private Integer maxmoney;


    /**
     * 押金
     */

    @TableField(value = "pledge")
    private Integer pledge;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：车辆信息
	 */
    public Integer getClTypes() {
        return clTypes;
    }


    /**
	 * 获取：车辆信息
	 */

    public void setClTypes(Integer clTypes) {
        this.clTypes = clTypes;
    }
    /**
	 * 设置：租车用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：租车用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：租赁期限
	 */
    public Integer getDay() {
        return day;
    }


    /**
	 * 获取：租赁期限
	 */

    public void setDay(Integer day) {
        this.day = day;
    }
    /**
	 * 设置：是否签订合同 Search
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否签订合同 Search
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }
    /**
	 * 设置：总价格
	 */
    public Integer getMaxmoney() {
        return maxmoney;
    }


    /**
	 * 获取：总价格
	 */

    public void setMaxmoney(Integer maxmoney) {
        this.maxmoney = maxmoney;
    }
    /**
	 * 设置：押金
	 */
    public Integer getPledge() {
        return pledge;
    }


    /**
	 * 获取：押金
	 */

    public void setPledge(Integer pledge) {
        this.pledge = pledge;
    }

}

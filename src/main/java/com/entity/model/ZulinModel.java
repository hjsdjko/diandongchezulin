package com.entity.model;

import com.entity.ZulinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租赁模块
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-20
 */
public class ZulinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆信息
     */
    private Integer clTypes;


    /**
     * 租车用户
     */
    private Integer yhTypes;


    /**
     * 租赁期限
     */
    private Integer day;


    /**
     * 是否签订合同 Search
     */
    private Integer sfTypes;


    /**
     * 总价格
     */
    private Integer maxmoney;


    /**
     * 押金
     */
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

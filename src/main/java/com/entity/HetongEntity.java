package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 租赁合同
 *
 * @email
 * @date 2021-03-20
 */
@TableName("hetong")
public class HetongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public HetongEntity() {

    }

    public HetongEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 合同名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 合同文件
     */
    @TableField(value = "wenjian_file")

    private String wenjianFile;


    /**
     * 签署人
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 签署日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "qianding_time",fill = FieldFill.UPDATE)

    private Date qiandingTime;


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
	 * 设置：合同名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：合同名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：合同文件
	 */
    public String getWenjianFile() {
        return wenjianFile;
    }


    /**
	 * 获取：合同文件
	 */

    public void setWenjianFile(String wenjianFile) {
        this.wenjianFile = wenjianFile;
    }
    /**
	 * 设置：签署人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：签署人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：签署日期
	 */
    public Date getQiandingTime() {
        return qiandingTime;
    }


    /**
	 * 获取：签署日期
	 */

    public void setQiandingTime(Date qiandingTime) {
        this.qiandingTime = qiandingTime;
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

    @Override
    public String toString() {
    return "Hetong{" +
            "id=" + id +
            ", name=" + name +
            ", wenjianFile=" + wenjianFile +
            ", yhTypes=" + yhTypes +
            ", qiandingTime=" + qiandingTime +
            ", pledge=" + pledge +
    "}";
    }
    }

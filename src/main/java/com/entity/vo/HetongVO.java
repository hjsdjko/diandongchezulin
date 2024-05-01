package com.entity.vo;

import com.entity.HetongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 租赁合同
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-20
 */
@TableName("hetong")
public class HetongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 合同名称 Search
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qianding_time")
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
	 * 设置：合同名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：合同名称 Search
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

}

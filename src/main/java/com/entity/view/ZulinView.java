package com.entity.view;

import com.entity.ZulinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 租赁模块
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-20
 */
@TableName("zulin")
public class ZulinView extends ZulinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ZulinView() {

	}

	public ZulinView(ZulinEntity zulinEntity) {
		try {
			BeanUtils.copyProperties(this, zulinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

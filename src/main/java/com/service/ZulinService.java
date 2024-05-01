package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZulinEntity;
import java.util.Map;

/**
 * 租赁模块 服务类
 * @since 2021-03-20
 */
public interface ZulinService extends IService<ZulinEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
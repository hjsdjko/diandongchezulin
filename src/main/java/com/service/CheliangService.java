package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangEntity;
import java.util.Map;

/**
 * 车辆 服务类
 * @since 2021-03-20
 */
public interface CheliangService extends IService<CheliangEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
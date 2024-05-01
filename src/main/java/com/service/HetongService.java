package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HetongEntity;
import java.util.Map;

/**
 * 租赁合同 服务类
 * @since 2021-03-20
 */
public interface HetongService extends IService<HetongEntity> {

     PageUtils queryPage(Map<String, Object> params);

}
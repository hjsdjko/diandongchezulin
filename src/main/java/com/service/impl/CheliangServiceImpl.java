package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.CheliangDao;
import com.entity.CheliangEntity;
import com.service.CheliangService;
import com.entity.view.CheliangView;

/**
 * 车辆 服务实现类
 * @since 2021-03-20
 */
@Service("cheliangService")
@Transactional
public class CheliangServiceImpl extends ServiceImpl<CheliangDao, CheliangEntity> implements CheliangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CheliangView> page =new Query<CheliangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}

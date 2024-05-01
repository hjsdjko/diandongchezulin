package com.dao;

import com.entity.ZulinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZulinView;

/**
 * 租赁模块 Dao 接口
 *
 * @since 2021-03-20
 */
public interface ZulinDao extends BaseMapper<ZulinEntity> {

   List<ZulinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

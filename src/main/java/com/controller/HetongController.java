package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.HetongEntity;

import com.service.HetongService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 租赁合同
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/hetong")
public class HetongController {
    private static final Logger logger = LoggerFactory.getLogger(HetongController.class);

    @Autowired
    private HetongService hetongService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
        }
        PageUtils page = hetongService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        HetongEntity hetong = hetongService.selectById(id);
        if(hetong!=null){
            return R.ok().put("data", hetong);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .eq("name", hetong.getName())
            .eq("yh_types", hetong.getYhTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if("".equals(hetong.getWenjianFile()) || "null".equals(hetong.getWenjianFile())){
            hetong.setWenjianFile(null);
        }
            hetong.setQiandingTime(new Date());
        if(hetongEntity==null){
            hetongService.insert(hetong);
            return R.ok();
        }else {
            return R.error(511,"已经签过相同的合同了");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .notIn("id",hetong.getId())
            .eq("name", hetong.getName())
            .eq("yh_types", hetong.getYhTypes())
            .eq("pledge", hetong.getPledge())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if("".equals(hetong.getWenjianFile()) || "null".equals(hetong.getWenjianFile())){
                hetong.setWenjianFile(null);
        }
                hetong.setQiandingTime(new Date());
        if(hetongEntity==null){
            hetongService.updateById(hetong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        hetongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


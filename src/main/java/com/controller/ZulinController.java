package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CheliangEntity;
import com.service.CheliangService;
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

import com.entity.ZulinEntity;

import com.service.ZulinService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 租赁模块
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/zulin")
public class ZulinController {
    private static final Logger logger = LoggerFactory.getLogger(ZulinController.class);

    @Autowired
    private CheliangService cheliangService;

    @Autowired
    private ZulinService zulinService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
        }
        PageUtils page = zulinService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ZulinEntity zulin = zulinService.selectById(id);
        if(zulin!=null){
            return R.ok().put("data", zulin);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZulinEntity zulin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ZulinEntity> queryWrapper = new EntityWrapper<ZulinEntity>()
            .eq("cl_types", zulin.getClTypes())
            .eq("yh_types", zulin.getYhTypes())
            .eq("day", zulin.getDay())
            .eq("sf_types", zulin.getSfTypes())
            .eq("maxmoney", zulin.getMaxmoney())
            .eq("pledge", zulin.getPledge())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinEntity zulinEntity = zulinService.selectOne(queryWrapper);
        if(zulinEntity==null){
            zulinService.insert(zulin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZulinEntity zulin, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ZulinEntity> queryWrapper = new EntityWrapper<ZulinEntity>()
            .notIn("id",zulin.getId())
            .eq("cl_types", zulin.getClTypes())
            .eq("yh_types", zulin.getYhTypes())
            .eq("day", zulin.getDay())
            .eq("sf_types", zulin.getSfTypes())
            .eq("maxmoney", zulin.getMaxmoney())
            .eq("pledge", zulin.getPledge())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinEntity zulinEntity = zulinService.selectOne(queryWrapper);
        if(zulinEntity==null){
            zulinService.updateById(zulin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/detail")
    public R detail(Integer ids){
        ZulinEntity zulin = zulinService.selectById(ids);
        if(zulin == null){
            return R.error();
        }
        zulin.setPledge(0);
        zulin.setZhuangtai(1);
        boolean b = zulinService.updateById(zulin);
        if(b){
            CheliangEntity cheliang = cheliangService.selectById(zulin.getClTypes());
            if(cheliang == null){
                return R.error();
            }
            cheliang.setZtTypes(2);
            cheliangService.updateById(cheliang);
            return R.ok();
        }
        return R.error();
    }


    /**
    * 还车
    */
    @RequestMapping("/huanche")
    public R huanche(Integer ids){
        ZulinEntity zulin = zulinService.selectById(ids);
        if(zulin == null){
            return R.error();
        }
        CheliangEntity cheliang = cheliangService.selectById(zulin.getClTypes());
        if(cheliang == null){
            return R.error();
        }
        zulin.setZhuangtai(1);
        boolean b = zulinService.updateById(zulin);
        if(b){
            cheliang.setZtTypes(2);
            cheliangService.updateById(cheliang);
            return R.ok();
        }
        return R.error();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        zulinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


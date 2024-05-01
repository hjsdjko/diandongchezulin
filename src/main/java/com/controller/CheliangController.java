package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.ZulinEntity;
import com.service.ZulinService;
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

import com.entity.CheliangEntity;

import com.service.CheliangService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/cheliang")
public class CheliangController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangController.class);

    @Autowired
    private ZulinService zulinService;

    @Autowired
    private CheliangService cheliangService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = cheliangService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        CheliangEntity cheliang = cheliangService.selectById(id);
        if(cheliang!=null){
            return R.ok().put("data", cheliang);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .eq("name", cheliang.getName())
            .eq("brand", cheliang.getBrand())
            .eq("design", cheliang.getDesign())
            .eq("money", cheliang.getMoney())
            .eq("age", cheliang.getAge())
            .eq("zt_types", cheliang.getZtTypes())
            .eq("miaoshu_content", cheliang.getMiaoshuContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if("".equals(cheliang.getImgPhoto()) || "null".equals(cheliang.getImgPhoto())){
            cheliang.setImgPhoto(null);
        }
        if(cheliangEntity==null){
            cheliang.setZtTypes(2);
            cheliangService.insert(cheliang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .notIn("id",cheliang.getId())
            .eq("name", cheliang.getName())
            .eq("brand", cheliang.getBrand())
            .eq("design", cheliang.getDesign())
            .eq("money", cheliang.getMoney())
            .eq("age", cheliang.getAge())
            .eq("zt_types", cheliang.getZtTypes())
            .eq("miaoshu_content", cheliang.getMiaoshuContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if("".equals(cheliang.getImgPhoto()) || "null".equals(cheliang.getImgPhoto())){
                cheliang.setImgPhoto(null);
        }
        if(cheliangEntity==null){
            cheliangService.updateById(cheliang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/lease")
    public R lease(Integer ids,Integer day, HttpServletRequest request){
        if(day == null){
            return R.error("租赁时长不能为空哦");
        }
        if(day > 24){
            return  R.error("租赁时长不能大于24小时哦");
        }
        CheliangEntity cheliang = cheliangService.selectById(ids);
        if(cheliang == null){
           return R.error();
        }
        ZulinEntity zulin = new ZulinEntity();
        zulin.setClTypes(cheliang.getId());
        zulin.setDay(day);
        zulin.setZhuangtai(0);
        zulin.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        if(zulin.getMaxmoney() == null){
            zulin.setMaxmoney(0);
        }
        zulin.setMaxmoney(day*cheliang.getMoney());
        Double v = day * cheliang.getMoney() * 0.4;
        zulin.setPledge(v.intValue());
        zulin.setSfTypes(2);

        Wrapper<ZulinEntity> queryWrapper = new EntityWrapper<ZulinEntity>()
                .eq("cl_types", zulin.getClTypes())
                .eq("yh_types", zulin.getYhTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZulinEntity zulinEntity = zulinService.selectOne(queryWrapper);
        if(zulinEntity==null){
            cheliang.setZtTypes(1);
            cheliangService.updateById(cheliang);
            zulinService.insert(zulin);
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
        cheliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}


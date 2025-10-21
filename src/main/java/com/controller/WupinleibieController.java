package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WupinleibieEntity;
import com.entity.view.WupinleibieView;

import com.service.WupinleibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 物品类别
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-28 22:11:26
 */
@RestController
@RequestMapping("/wupinleibie")
public class WupinleibieController {
    @Autowired
    private WupinleibieService wupinleibieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WupinleibieEntity wupinleibie,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WupinleibieEntity> ew = new EntityWrapper<WupinleibieEntity>();


        //查询结果
		PageUtils page = wupinleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wupinleibie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WupinleibieEntity wupinleibie, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WupinleibieEntity> ew = new EntityWrapper<WupinleibieEntity>();

        //查询结果
		PageUtils page = wupinleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wupinleibie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WupinleibieEntity wupinleibie){
       	EntityWrapper<WupinleibieEntity> ew = new EntityWrapper<WupinleibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wupinleibie, "wupinleibie")); 
        return R.ok().put("data", wupinleibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WupinleibieEntity wupinleibie){
        EntityWrapper< WupinleibieEntity> ew = new EntityWrapper< WupinleibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wupinleibie, "wupinleibie")); 
		WupinleibieView wupinleibieView =  wupinleibieService.selectView(ew);
		return R.ok("查询物品类别成功").put("data", wupinleibieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WupinleibieEntity wupinleibie = wupinleibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wupinleibie,deSens);
        return R.ok().put("data", wupinleibie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WupinleibieEntity wupinleibie = wupinleibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wupinleibie,deSens);
        return R.ok().put("data", wupinleibie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WupinleibieEntity wupinleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wupinleibie);
        wupinleibieService.insert(wupinleibie);
        return R.ok().put("data",wupinleibie.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WupinleibieEntity wupinleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wupinleibie);
        wupinleibieService.insert(wupinleibie);
        return R.ok().put("data",wupinleibie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WupinleibieEntity wupinleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wupinleibie);
        //全部更新
        wupinleibieService.updateById(wupinleibie);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wupinleibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}

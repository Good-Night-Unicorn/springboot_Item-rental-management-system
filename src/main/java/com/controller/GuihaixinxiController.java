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

import com.entity.GuihaixinxiEntity;
import com.entity.view.GuihaixinxiView;

import com.service.GuihaixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 归还信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-28 22:11:26
 */
@RestController
@RequestMapping("/guihaixinxi")
public class GuihaixinxiController {
    @Autowired
    private GuihaixinxiService guihaixinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuihaixinxiEntity guihaixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			guihaixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();


        //查询结果
		PageUtils page = guihaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaixinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GuihaixinxiEntity guihaixinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();

        //查询结果
		PageUtils page = guihaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuihaixinxiEntity guihaixinxi){
       	EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guihaixinxi, "guihaixinxi")); 
        return R.ok().put("data", guihaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuihaixinxiEntity guihaixinxi){
        EntityWrapper< GuihaixinxiEntity> ew = new EntityWrapper< GuihaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guihaixinxi, "guihaixinxi")); 
		GuihaixinxiView guihaixinxiView =  guihaixinxiService.selectView(ew);
		return R.ok("查询归还信息成功").put("data", guihaixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuihaixinxiEntity guihaixinxi = guihaixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaixinxi,deSens);
        return R.ok().put("data", guihaixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuihaixinxiEntity guihaixinxi = guihaixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaixinxi,deSens);
        return R.ok().put("data", guihaixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaixinxi);
        guihaixinxiService.insert(guihaixinxi);
        return R.ok().put("data",guihaixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaixinxi);
        guihaixinxiService.insert(guihaixinxi);
        return R.ok().put("data",guihaixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaixinxi);
        //全部更新
        guihaixinxiService.updateById(guihaixinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guihaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,GuihaixinxiEntity guihaixinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            guihaixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<GuihaixinxiEntity> ew = new EntityWrapper<GuihaixinxiEntity>();
        int count = guihaixinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaixinxi), params), params));
        return R.ok().put("data", count);
    }

}

package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
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

import com.entity.DiannaoxinxiEntity;
import com.entity.view.DiannaoxinxiView;

import com.service.DiannaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 电脑信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-22 15:56:48
 */
@RestController
@RequestMapping("/diannaoxinxi")
public class DiannaoxinxiController {
    @Autowired
    private DiannaoxinxiService diannaoxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiannaoxinxiEntity diannaoxinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<DiannaoxinxiEntity> ew = new EntityWrapper<DiannaoxinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = diannaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diannaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiannaoxinxiEntity diannaoxinxi, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<DiannaoxinxiEntity> ew = new EntityWrapper<DiannaoxinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = diannaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diannaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiannaoxinxiEntity diannaoxinxi){
       	EntityWrapper<DiannaoxinxiEntity> ew = new EntityWrapper<DiannaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diannaoxinxi, "diannaoxinxi")); 
        return R.ok().put("data", diannaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiannaoxinxiEntity diannaoxinxi){
        EntityWrapper< DiannaoxinxiEntity> ew = new EntityWrapper< DiannaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diannaoxinxi, "diannaoxinxi")); 
		DiannaoxinxiView diannaoxinxiView =  diannaoxinxiService.selectView(ew);
		return R.ok("查询电脑信息成功").put("data", diannaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiannaoxinxiEntity diannaoxinxi = diannaoxinxiService.selectById(id);
		diannaoxinxi.setClicknum(diannaoxinxi.getClicknum()+1);
		diannaoxinxi.setClicktime(new Date());
		diannaoxinxiService.updateById(diannaoxinxi);
        return R.ok().put("data", diannaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiannaoxinxiEntity diannaoxinxi = diannaoxinxiService.selectById(id);
		diannaoxinxi.setClicknum(diannaoxinxi.getClicknum()+1);
		diannaoxinxi.setClicktime(new Date());
		diannaoxinxiService.updateById(diannaoxinxi);
        return R.ok().put("data", diannaoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        DiannaoxinxiEntity diannaoxinxi = diannaoxinxiService.selectById(id);
        if(type.equals("1")) {
        	diannaoxinxi.setThumbsupnum(diannaoxinxi.getThumbsupnum()+1);
        } else {
        	diannaoxinxi.setCrazilynum(diannaoxinxi.getCrazilynum()+1);
        }
        diannaoxinxiService.updateById(diannaoxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiannaoxinxiEntity diannaoxinxi, HttpServletRequest request){
    	diannaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diannaoxinxi);
        diannaoxinxiService.insert(diannaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiannaoxinxiEntity diannaoxinxi, HttpServletRequest request){
    	diannaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diannaoxinxi);
        diannaoxinxiService.insert(diannaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiannaoxinxiEntity diannaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diannaoxinxi);
        diannaoxinxiService.updateById(diannaoxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diannaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiannaoxinxiEntity diannaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiannaoxinxiEntity> ew = new EntityWrapper<DiannaoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = diannaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diannaoxinxi), params), params));
        return R.ok().put("data", page);
    }









}

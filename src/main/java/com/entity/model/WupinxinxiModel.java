package com.entity.model;

import com.entity.WupinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 物品信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-02-28 22:11:26
 */
public class WupinxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 物品名称
	 */
	
	private String wupinmingcheng;
		
	/**
	 * 物品类别
	 */
	
	private String wupinleibie;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 库存
	 */
	
	private Integer shuliang;
		
	/**
	 * 租金
	 */
	
	private Double zujin;
		
	/**
	 * 租赁期限
	 */
	
	private String zulinqixian;
		
	/**
	 * 新旧程度
	 */
	
	private String xinjiuchengdu;
		
	/**
	 * 租赁状态
	 */
	
	private String zulinzhuangtai;
		
	/**
	 * 租赁流程
	 */
	
	private String zulinliucheng;
		
	/**
	 * 物品详情
	 */
	
	private String wupinxiangqing;
				
	
	/**
	 * 设置：物品名称
	 */
	 
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
				
	
	/**
	 * 设置：物品类别
	 */
	 
	public void setWupinleibie(String wupinleibie) {
		this.wupinleibie = wupinleibie;
	}
	
	/**
	 * 获取：物品类别
	 */
	public String getWupinleibie() {
		return wupinleibie;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：租金
	 */
	 
	public void setZujin(Double zujin) {
		this.zujin = zujin;
	}
	
	/**
	 * 获取：租金
	 */
	public Double getZujin() {
		return zujin;
	}
				
	
	/**
	 * 设置：租赁期限
	 */
	 
	public void setZulinqixian(String zulinqixian) {
		this.zulinqixian = zulinqixian;
	}
	
	/**
	 * 获取：租赁期限
	 */
	public String getZulinqixian() {
		return zulinqixian;
	}
				
	
	/**
	 * 设置：新旧程度
	 */
	 
	public void setXinjiuchengdu(String xinjiuchengdu) {
		this.xinjiuchengdu = xinjiuchengdu;
	}
	
	/**
	 * 获取：新旧程度
	 */
	public String getXinjiuchengdu() {
		return xinjiuchengdu;
	}
				
	
	/**
	 * 设置：租赁状态
	 */
	 
	public void setZulinzhuangtai(String zulinzhuangtai) {
		this.zulinzhuangtai = zulinzhuangtai;
	}
	
	/**
	 * 获取：租赁状态
	 */
	public String getZulinzhuangtai() {
		return zulinzhuangtai;
	}
				
	
	/**
	 * 设置：租赁流程
	 */
	 
	public void setZulinliucheng(String zulinliucheng) {
		this.zulinliucheng = zulinliucheng;
	}
	
	/**
	 * 获取：租赁流程
	 */
	public String getZulinliucheng() {
		return zulinliucheng;
	}
				
	
	/**
	 * 设置：物品详情
	 */
	 
	public void setWupinxiangqing(String wupinxiangqing) {
		this.wupinxiangqing = wupinxiangqing;
	}
	
	/**
	 * 获取：物品详情
	 */
	public String getWupinxiangqing() {
		return wupinxiangqing;
	}
			
}

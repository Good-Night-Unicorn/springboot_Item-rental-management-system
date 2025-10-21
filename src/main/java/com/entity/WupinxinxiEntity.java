package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 物品信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-02-28 22:11:26
 */
@TableName("wupinxinxi")
public class WupinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WupinxinxiEntity() {
		
	}
	
	public WupinxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 物品编号
	 */
					
	private String wupinbianhao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：物品编号
	 */
	public void setWupinbianhao(String wupinbianhao) {
		this.wupinbianhao = wupinbianhao;
	}
	/**
	 * 获取：物品编号
	 */
	public String getWupinbianhao() {
		return wupinbianhao;
	}
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

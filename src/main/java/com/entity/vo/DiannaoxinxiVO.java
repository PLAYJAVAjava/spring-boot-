package com.entity.vo;

import com.entity.DiannaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 电脑信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-22 15:56:48
 */
public class DiannaoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 电脑类型
	 */
	
	private String diannaoleixing;
		
	/**
	 * 品牌
	 */
	
	private String pinpai;
		
	/**
	 * 生产商
	 */
	
	private String shengchanshang;
		
	/**
	 * 上架日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangjiariqi;
		
	/**
	 * 详情参数
	 */
	
	private String xiangqingcanshu;
		
	/**
	 * 电脑图片
	 */
	
	private String diannaotupian;
		
	/**
	 * 单限
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：电脑类型
	 */
	 
	public void setDiannaoleixing(String diannaoleixing) {
		this.diannaoleixing = diannaoleixing;
	}
	
	/**
	 * 获取：电脑类型
	 */
	public String getDiannaoleixing() {
		return diannaoleixing;
	}
				
	
	/**
	 * 设置：品牌
	 */
	 
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
				
	
	/**
	 * 设置：生产商
	 */
	 
	public void setShengchanshang(String shengchanshang) {
		this.shengchanshang = shengchanshang;
	}
	
	/**
	 * 获取：生产商
	 */
	public String getShengchanshang() {
		return shengchanshang;
	}
				
	
	/**
	 * 设置：上架日期
	 */
	 
	public void setShangjiariqi(Date shangjiariqi) {
		this.shangjiariqi = shangjiariqi;
	}
	
	/**
	 * 获取：上架日期
	 */
	public Date getShangjiariqi() {
		return shangjiariqi;
	}
				
	
	/**
	 * 设置：详情参数
	 */
	 
	public void setXiangqingcanshu(String xiangqingcanshu) {
		this.xiangqingcanshu = xiangqingcanshu;
	}
	
	/**
	 * 获取：详情参数
	 */
	public String getXiangqingcanshu() {
		return xiangqingcanshu;
	}
				
	
	/**
	 * 设置：电脑图片
	 */
	 
	public void setDiannaotupian(String diannaotupian) {
		this.diannaotupian = diannaotupian;
	}
	
	/**
	 * 获取：电脑图片
	 */
	public String getDiannaotupian() {
		return diannaotupian;
	}
				
	
	/**
	 * 设置：单限
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}

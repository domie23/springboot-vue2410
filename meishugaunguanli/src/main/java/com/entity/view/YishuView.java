package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YishuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 艺术信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yishu")
public class YishuView extends YishuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 艺术类型的值
	*/
	@ColumnInfo(comment="艺术类型的字典表值",type="varchar(200)")
	private String yishuValue;

	//级联表 作者
		/**
		* 作者名称
		*/

		@ColumnInfo(comment="作者名称",type="varchar(200)")
		private String zuozheName;
		/**
		* 作者编号
		*/

		@ColumnInfo(comment="作者编号",type="varchar(200)")
		private String zuozheUuidNumber;
		/**
		* 作者照片
		*/

		@ColumnInfo(comment="作者照片",type="varchar(200)")
		private String zuozhePhoto;
		/**
		* 作者地点
		*/

		@ColumnInfo(comment="作者地点",type="varchar(200)")
		private String zuozheAddress;
		/**
		* 获得奖项
		*/

		@ColumnInfo(comment="获得奖项",type="varchar(200)")
		private String zuozheJiangxinag;
		/**
		* 生年
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
		@DateTimeFormat
		@ColumnInfo(comment="生年",type="date")
		private Date zuozheTime;
		/**
		* 作者类型
		*/
		@ColumnInfo(comment="作者类型",type="int(11)")
		private Integer zuozheTypes;
			/**
			* 作者类型的值
			*/
			@ColumnInfo(comment="作者类型的字典表值",type="varchar(200)")
			private String zuozheValue;
		/**
		* 作者介绍
		*/

		@ColumnInfo(comment="作者介绍",type="longtext")
		private String zuozheContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zuozheDelete;



	public YishuView() {

	}

	public YishuView(YishuEntity yishuEntity) {
		try {
			BeanUtils.copyProperties(this, yishuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 艺术类型的值
	*/
	public String getYishuValue() {
		return yishuValue;
	}
	/**
	* 设置： 艺术类型的值
	*/
	public void setYishuValue(String yishuValue) {
		this.yishuValue = yishuValue;
	}


	//级联表的get和set 作者

		/**
		* 获取： 作者名称
		*/
		public String getZuozheName() {
			return zuozheName;
		}
		/**
		* 设置： 作者名称
		*/
		public void setZuozheName(String zuozheName) {
			this.zuozheName = zuozheName;
		}

		/**
		* 获取： 作者编号
		*/
		public String getZuozheUuidNumber() {
			return zuozheUuidNumber;
		}
		/**
		* 设置： 作者编号
		*/
		public void setZuozheUuidNumber(String zuozheUuidNumber) {
			this.zuozheUuidNumber = zuozheUuidNumber;
		}

		/**
		* 获取： 作者照片
		*/
		public String getZuozhePhoto() {
			return zuozhePhoto;
		}
		/**
		* 设置： 作者照片
		*/
		public void setZuozhePhoto(String zuozhePhoto) {
			this.zuozhePhoto = zuozhePhoto;
		}

		/**
		* 获取： 作者地点
		*/
		public String getZuozheAddress() {
			return zuozheAddress;
		}
		/**
		* 设置： 作者地点
		*/
		public void setZuozheAddress(String zuozheAddress) {
			this.zuozheAddress = zuozheAddress;
		}

		/**
		* 获取： 获得奖项
		*/
		public String getZuozheJiangxinag() {
			return zuozheJiangxinag;
		}
		/**
		* 设置： 获得奖项
		*/
		public void setZuozheJiangxinag(String zuozheJiangxinag) {
			this.zuozheJiangxinag = zuozheJiangxinag;
		}

		/**
		* 获取： 生年
		*/
		public Date getZuozheTime() {
			return zuozheTime;
		}
		/**
		* 设置： 生年
		*/
		public void setZuozheTime(Date zuozheTime) {
			this.zuozheTime = zuozheTime;
		}
		/**
		* 获取： 作者类型
		*/
		public Integer getZuozheTypes() {
			return zuozheTypes;
		}
		/**
		* 设置： 作者类型
		*/
		public void setZuozheTypes(Integer zuozheTypes) {
			this.zuozheTypes = zuozheTypes;
		}


			/**
			* 获取： 作者类型的值
			*/
			public String getZuozheValue() {
				return zuozheValue;
			}
			/**
			* 设置： 作者类型的值
			*/
			public void setZuozheValue(String zuozheValue) {
				this.zuozheValue = zuozheValue;
			}

		/**
		* 获取： 作者介绍
		*/
		public String getZuozheContent() {
			return zuozheContent;
		}
		/**
		* 设置： 作者介绍
		*/
		public void setZuozheContent(String zuozheContent) {
			this.zuozheContent = zuozheContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZuozheDelete() {
			return zuozheDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZuozheDelete(Integer zuozheDelete) {
			this.zuozheDelete = zuozheDelete;
		}


	@Override
	public String toString() {
		return "YishuView{" +
			", yishuValue=" + yishuValue +
			", zuozheName=" + zuozheName +
			", zuozheUuidNumber=" + zuozheUuidNumber +
			", zuozhePhoto=" + zuozhePhoto +
			", zuozheAddress=" + zuozheAddress +
			", zuozheJiangxinag=" + zuozheJiangxinag +
			", zuozheTime=" + DateUtil.convertString(zuozheTime,"yyyy-MM-dd") +
			", zuozheContent=" + zuozheContent +
			", zuozheDelete=" + zuozheDelete +
			"} " + super.toString();
	}
}

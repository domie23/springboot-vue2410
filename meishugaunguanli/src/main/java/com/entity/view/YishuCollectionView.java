package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YishuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 艺术收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yishu_collection")
public class YishuCollectionView extends YishuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String yishuCollectionValue;

	//级联表 艺术信息
							/**
		* 艺术名称
		*/

		@ColumnInfo(comment="艺术名称",type="varchar(200)")
		private String yishuName;
		/**
		* 艺术编号
		*/

		@ColumnInfo(comment="艺术编号",type="varchar(200)")
		private String yishuUuidNumber;
		/**
		* 艺术照片
		*/

		@ColumnInfo(comment="艺术照片",type="varchar(200)")
		private String yishuPhoto;
		/**
		* 艺术地点
		*/

		@ColumnInfo(comment="艺术地点",type="varchar(200)")
		private String yishuAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 艺术类型
		*/
		@ColumnInfo(comment="艺术类型",type="int(11)")
		private Integer yishuTypes;
			/**
			* 艺术类型的值
			*/
			@ColumnInfo(comment="艺术类型的字典表值",type="varchar(200)")
			private String yishuValue;
		/**
		* 艺术热度
		*/

		@ColumnInfo(comment="艺术热度",type="int(11)")
		private Integer yishuClicknum;
		/**
		* 艺术介绍
		*/

		@ColumnInfo(comment="艺术介绍",type="longtext")
		private String yishuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yishuDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public YishuCollectionView() {

	}

	public YishuCollectionView(YishuCollectionEntity yishuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, yishuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getYishuCollectionValue() {
		return yishuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setYishuCollectionValue(String yishuCollectionValue) {
		this.yishuCollectionValue = yishuCollectionValue;
	}


	//级联表的get和set 艺术信息

		/**
		* 获取： 艺术名称
		*/
		public String getYishuName() {
			return yishuName;
		}
		/**
		* 设置： 艺术名称
		*/
		public void setYishuName(String yishuName) {
			this.yishuName = yishuName;
		}

		/**
		* 获取： 艺术编号
		*/
		public String getYishuUuidNumber() {
			return yishuUuidNumber;
		}
		/**
		* 设置： 艺术编号
		*/
		public void setYishuUuidNumber(String yishuUuidNumber) {
			this.yishuUuidNumber = yishuUuidNumber;
		}

		/**
		* 获取： 艺术照片
		*/
		public String getYishuPhoto() {
			return yishuPhoto;
		}
		/**
		* 设置： 艺术照片
		*/
		public void setYishuPhoto(String yishuPhoto) {
			this.yishuPhoto = yishuPhoto;
		}

		/**
		* 获取： 艺术地点
		*/
		public String getYishuAddress() {
			return yishuAddress;
		}
		/**
		* 设置： 艺术地点
		*/
		public void setYishuAddress(String yishuAddress) {
			this.yishuAddress = yishuAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 艺术类型
		*/
		public Integer getYishuTypes() {
			return yishuTypes;
		}
		/**
		* 设置： 艺术类型
		*/
		public void setYishuTypes(Integer yishuTypes) {
			this.yishuTypes = yishuTypes;
		}


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

		/**
		* 获取： 艺术热度
		*/
		public Integer getYishuClicknum() {
			return yishuClicknum;
		}
		/**
		* 设置： 艺术热度
		*/
		public void setYishuClicknum(Integer yishuClicknum) {
			this.yishuClicknum = yishuClicknum;
		}

		/**
		* 获取： 艺术介绍
		*/
		public String getYishuContent() {
			return yishuContent;
		}
		/**
		* 设置： 艺术介绍
		*/
		public void setYishuContent(String yishuContent) {
			this.yishuContent = yishuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYishuDelete() {
			return yishuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYishuDelete(Integer yishuDelete) {
			this.yishuDelete = yishuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "YishuCollectionView{" +
			", yishuCollectionValue=" + yishuCollectionValue +
			", yishuName=" + yishuName +
			", yishuUuidNumber=" + yishuUuidNumber +
			", yishuPhoto=" + yishuPhoto +
			", yishuAddress=" + yishuAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", yishuClicknum=" + yishuClicknum +
			", yishuContent=" + yishuContent +
			", yishuDelete=" + yishuDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}

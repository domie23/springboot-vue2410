package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 艺术信息
 *
 * @author 
 * @email
 */
@TableName("yishu")
public class YishuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishuEntity() {

	}

	public YishuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 作者
     */
    @ColumnInfo(comment="作者",type="int(11)")
    @TableField(value = "zuozhe_id")

    private Integer zuozheId;


    /**
     * 艺术名称
     */
    @ColumnInfo(comment="艺术名称",type="varchar(200)")
    @TableField(value = "yishu_name")

    private String yishuName;


    /**
     * 艺术编号
     */
    @ColumnInfo(comment="艺术编号",type="varchar(200)")
    @TableField(value = "yishu_uuid_number")

    private String yishuUuidNumber;


    /**
     * 艺术照片
     */
    @ColumnInfo(comment="艺术照片",type="varchar(200)")
    @TableField(value = "yishu_photo")

    private String yishuPhoto;


    /**
     * 艺术地点
     */
    @ColumnInfo(comment="艺术地点",type="varchar(200)")
    @TableField(value = "yishu_address")

    private String yishuAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 艺术类型
     */
    @ColumnInfo(comment="艺术类型",type="int(11)")
    @TableField(value = "yishu_types")

    private Integer yishuTypes;


    /**
     * 艺术热度
     */
    @ColumnInfo(comment="艺术热度",type="int(11)")
    @TableField(value = "yishu_clicknum")

    private Integer yishuClicknum;


    /**
     * 艺术介绍
     */
    @ColumnInfo(comment="艺术介绍",type="longtext")
    @TableField(value = "yishu_content")

    private String yishuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yishu_delete")

    private Integer yishuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：作者
	 */
    public Integer getZuozheId() {
        return zuozheId;
    }
    /**
	 * 设置：作者
	 */

    public void setZuozheId(Integer zuozheId) {
        this.zuozheId = zuozheId;
    }
    /**
	 * 获取：艺术名称
	 */
    public String getYishuName() {
        return yishuName;
    }
    /**
	 * 设置：艺术名称
	 */

    public void setYishuName(String yishuName) {
        this.yishuName = yishuName;
    }
    /**
	 * 获取：艺术编号
	 */
    public String getYishuUuidNumber() {
        return yishuUuidNumber;
    }
    /**
	 * 设置：艺术编号
	 */

    public void setYishuUuidNumber(String yishuUuidNumber) {
        this.yishuUuidNumber = yishuUuidNumber;
    }
    /**
	 * 获取：艺术照片
	 */
    public String getYishuPhoto() {
        return yishuPhoto;
    }
    /**
	 * 设置：艺术照片
	 */

    public void setYishuPhoto(String yishuPhoto) {
        this.yishuPhoto = yishuPhoto;
    }
    /**
	 * 获取：艺术地点
	 */
    public String getYishuAddress() {
        return yishuAddress;
    }
    /**
	 * 设置：艺术地点
	 */

    public void setYishuAddress(String yishuAddress) {
        this.yishuAddress = yishuAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：艺术类型
	 */
    public Integer getYishuTypes() {
        return yishuTypes;
    }
    /**
	 * 设置：艺术类型
	 */

    public void setYishuTypes(Integer yishuTypes) {
        this.yishuTypes = yishuTypes;
    }
    /**
	 * 获取：艺术热度
	 */
    public Integer getYishuClicknum() {
        return yishuClicknum;
    }
    /**
	 * 设置：艺术热度
	 */

    public void setYishuClicknum(Integer yishuClicknum) {
        this.yishuClicknum = yishuClicknum;
    }
    /**
	 * 获取：艺术介绍
	 */
    public String getYishuContent() {
        return yishuContent;
    }
    /**
	 * 设置：艺术介绍
	 */

    public void setYishuContent(String yishuContent) {
        this.yishuContent = yishuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYishuDelete() {
        return yishuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYishuDelete(Integer yishuDelete) {
        this.yishuDelete = yishuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yishu{" +
            ", id=" + id +
            ", zuozheId=" + zuozheId +
            ", yishuName=" + yishuName +
            ", yishuUuidNumber=" + yishuUuidNumber +
            ", yishuPhoto=" + yishuPhoto +
            ", yishuAddress=" + yishuAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", yishuTypes=" + yishuTypes +
            ", yishuClicknum=" + yishuClicknum +
            ", yishuContent=" + yishuContent +
            ", yishuDelete=" + yishuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

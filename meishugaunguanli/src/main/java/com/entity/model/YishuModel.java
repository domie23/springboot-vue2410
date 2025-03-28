package com.entity.model;

import com.entity.YishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 艺术信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YishuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作者
     */
    private Integer zuozheId;


    /**
     * 艺术名称
     */
    private String yishuName;


    /**
     * 艺术编号
     */
    private String yishuUuidNumber;


    /**
     * 艺术照片
     */
    private String yishuPhoto;


    /**
     * 艺术地点
     */
    private String yishuAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 艺术类型
     */
    private Integer yishuTypes;


    /**
     * 艺术热度
     */
    private Integer yishuClicknum;


    /**
     * 艺术介绍
     */
    private String yishuContent;


    /**
     * 逻辑删除
     */
    private Integer yishuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

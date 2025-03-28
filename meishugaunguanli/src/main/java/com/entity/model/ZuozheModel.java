package com.entity.model;

import com.entity.ZuozheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 作者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZuozheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作者名称
     */
    private String zuozheName;


    /**
     * 作者编号
     */
    private String zuozheUuidNumber;


    /**
     * 作者照片
     */
    private String zuozhePhoto;


    /**
     * 作者地点
     */
    private String zuozheAddress;


    /**
     * 获得奖项
     */
    private String zuozheJiangxinag;


    /**
     * 生年
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zuozheTime;


    /**
     * 作者类型
     */
    private Integer zuozheTypes;


    /**
     * 作者介绍
     */
    private String zuozheContent;


    /**
     * 逻辑删除
     */
    private Integer zuozheDelete;


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
	 * 获取：作者名称
	 */
    public String getZuozheName() {
        return zuozheName;
    }


    /**
	 * 设置：作者名称
	 */
    public void setZuozheName(String zuozheName) {
        this.zuozheName = zuozheName;
    }
    /**
	 * 获取：作者编号
	 */
    public String getZuozheUuidNumber() {
        return zuozheUuidNumber;
    }


    /**
	 * 设置：作者编号
	 */
    public void setZuozheUuidNumber(String zuozheUuidNumber) {
        this.zuozheUuidNumber = zuozheUuidNumber;
    }
    /**
	 * 获取：作者照片
	 */
    public String getZuozhePhoto() {
        return zuozhePhoto;
    }


    /**
	 * 设置：作者照片
	 */
    public void setZuozhePhoto(String zuozhePhoto) {
        this.zuozhePhoto = zuozhePhoto;
    }
    /**
	 * 获取：作者地点
	 */
    public String getZuozheAddress() {
        return zuozheAddress;
    }


    /**
	 * 设置：作者地点
	 */
    public void setZuozheAddress(String zuozheAddress) {
        this.zuozheAddress = zuozheAddress;
    }
    /**
	 * 获取：获得奖项
	 */
    public String getZuozheJiangxinag() {
        return zuozheJiangxinag;
    }


    /**
	 * 设置：获得奖项
	 */
    public void setZuozheJiangxinag(String zuozheJiangxinag) {
        this.zuozheJiangxinag = zuozheJiangxinag;
    }
    /**
	 * 获取：生年
	 */
    public Date getZuozheTime() {
        return zuozheTime;
    }


    /**
	 * 设置：生年
	 */
    public void setZuozheTime(Date zuozheTime) {
        this.zuozheTime = zuozheTime;
    }
    /**
	 * 获取：作者类型
	 */
    public Integer getZuozheTypes() {
        return zuozheTypes;
    }


    /**
	 * 设置：作者类型
	 */
    public void setZuozheTypes(Integer zuozheTypes) {
        this.zuozheTypes = zuozheTypes;
    }
    /**
	 * 获取：作者介绍
	 */
    public String getZuozheContent() {
        return zuozheContent;
    }


    /**
	 * 设置：作者介绍
	 */
    public void setZuozheContent(String zuozheContent) {
        this.zuozheContent = zuozheContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZuozheDelete() {
        return zuozheDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setZuozheDelete(Integer zuozheDelete) {
        this.zuozheDelete = zuozheDelete;
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

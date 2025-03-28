package com.entity.vo;

import com.entity.ZuozheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 作者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zuozhe")
public class ZuozheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 作者名称
     */

    @TableField(value = "zuozhe_name")
    private String zuozheName;


    /**
     * 作者编号
     */

    @TableField(value = "zuozhe_uuid_number")
    private String zuozheUuidNumber;


    /**
     * 作者照片
     */

    @TableField(value = "zuozhe_photo")
    private String zuozhePhoto;


    /**
     * 作者地点
     */

    @TableField(value = "zuozhe_address")
    private String zuozheAddress;


    /**
     * 获得奖项
     */

    @TableField(value = "zuozhe_jiangxinag")
    private String zuozheJiangxinag;


    /**
     * 生年
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zuozhe_time")
    private Date zuozheTime;


    /**
     * 作者类型
     */

    @TableField(value = "zuozhe_types")
    private Integer zuozheTypes;


    /**
     * 作者介绍
     */

    @TableField(value = "zuozhe_content")
    private String zuozheContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zuozhe_delete")
    private Integer zuozheDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：作者名称
	 */
    public String getZuozheName() {
        return zuozheName;
    }


    /**
	 * 获取：作者名称
	 */

    public void setZuozheName(String zuozheName) {
        this.zuozheName = zuozheName;
    }
    /**
	 * 设置：作者编号
	 */
    public String getZuozheUuidNumber() {
        return zuozheUuidNumber;
    }


    /**
	 * 获取：作者编号
	 */

    public void setZuozheUuidNumber(String zuozheUuidNumber) {
        this.zuozheUuidNumber = zuozheUuidNumber;
    }
    /**
	 * 设置：作者照片
	 */
    public String getZuozhePhoto() {
        return zuozhePhoto;
    }


    /**
	 * 获取：作者照片
	 */

    public void setZuozhePhoto(String zuozhePhoto) {
        this.zuozhePhoto = zuozhePhoto;
    }
    /**
	 * 设置：作者地点
	 */
    public String getZuozheAddress() {
        return zuozheAddress;
    }


    /**
	 * 获取：作者地点
	 */

    public void setZuozheAddress(String zuozheAddress) {
        this.zuozheAddress = zuozheAddress;
    }
    /**
	 * 设置：获得奖项
	 */
    public String getZuozheJiangxinag() {
        return zuozheJiangxinag;
    }


    /**
	 * 获取：获得奖项
	 */

    public void setZuozheJiangxinag(String zuozheJiangxinag) {
        this.zuozheJiangxinag = zuozheJiangxinag;
    }
    /**
	 * 设置：生年
	 */
    public Date getZuozheTime() {
        return zuozheTime;
    }


    /**
	 * 获取：生年
	 */

    public void setZuozheTime(Date zuozheTime) {
        this.zuozheTime = zuozheTime;
    }
    /**
	 * 设置：作者类型
	 */
    public Integer getZuozheTypes() {
        return zuozheTypes;
    }


    /**
	 * 获取：作者类型
	 */

    public void setZuozheTypes(Integer zuozheTypes) {
        this.zuozheTypes = zuozheTypes;
    }
    /**
	 * 设置：作者介绍
	 */
    public String getZuozheContent() {
        return zuozheContent;
    }


    /**
	 * 获取：作者介绍
	 */

    public void setZuozheContent(String zuozheContent) {
        this.zuozheContent = zuozheContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZuozheDelete() {
        return zuozheDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZuozheDelete(Integer zuozheDelete) {
        this.zuozheDelete = zuozheDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

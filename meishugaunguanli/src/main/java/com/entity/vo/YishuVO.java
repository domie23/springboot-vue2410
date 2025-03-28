package com.entity.vo;

import com.entity.YishuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 艺术信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yishu")
public class YishuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 作者
     */

    @TableField(value = "zuozhe_id")
    private Integer zuozheId;


    /**
     * 艺术名称
     */

    @TableField(value = "yishu_name")
    private String yishuName;


    /**
     * 艺术编号
     */

    @TableField(value = "yishu_uuid_number")
    private String yishuUuidNumber;


    /**
     * 艺术照片
     */

    @TableField(value = "yishu_photo")
    private String yishuPhoto;


    /**
     * 艺术地点
     */

    @TableField(value = "yishu_address")
    private String yishuAddress;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 艺术类型
     */

    @TableField(value = "yishu_types")
    private Integer yishuTypes;


    /**
     * 艺术热度
     */

    @TableField(value = "yishu_clicknum")
    private Integer yishuClicknum;


    /**
     * 艺术介绍
     */

    @TableField(value = "yishu_content")
    private String yishuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yishu_delete")
    private Integer yishuDelete;


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
	 * 设置：作者
	 */
    public Integer getZuozheId() {
        return zuozheId;
    }


    /**
	 * 获取：作者
	 */

    public void setZuozheId(Integer zuozheId) {
        this.zuozheId = zuozheId;
    }
    /**
	 * 设置：艺术名称
	 */
    public String getYishuName() {
        return yishuName;
    }


    /**
	 * 获取：艺术名称
	 */

    public void setYishuName(String yishuName) {
        this.yishuName = yishuName;
    }
    /**
	 * 设置：艺术编号
	 */
    public String getYishuUuidNumber() {
        return yishuUuidNumber;
    }


    /**
	 * 获取：艺术编号
	 */

    public void setYishuUuidNumber(String yishuUuidNumber) {
        this.yishuUuidNumber = yishuUuidNumber;
    }
    /**
	 * 设置：艺术照片
	 */
    public String getYishuPhoto() {
        return yishuPhoto;
    }


    /**
	 * 获取：艺术照片
	 */

    public void setYishuPhoto(String yishuPhoto) {
        this.yishuPhoto = yishuPhoto;
    }
    /**
	 * 设置：艺术地点
	 */
    public String getYishuAddress() {
        return yishuAddress;
    }


    /**
	 * 获取：艺术地点
	 */

    public void setYishuAddress(String yishuAddress) {
        this.yishuAddress = yishuAddress;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：艺术类型
	 */
    public Integer getYishuTypes() {
        return yishuTypes;
    }


    /**
	 * 获取：艺术类型
	 */

    public void setYishuTypes(Integer yishuTypes) {
        this.yishuTypes = yishuTypes;
    }
    /**
	 * 设置：艺术热度
	 */
    public Integer getYishuClicknum() {
        return yishuClicknum;
    }


    /**
	 * 获取：艺术热度
	 */

    public void setYishuClicknum(Integer yishuClicknum) {
        this.yishuClicknum = yishuClicknum;
    }
    /**
	 * 设置：艺术介绍
	 */
    public String getYishuContent() {
        return yishuContent;
    }


    /**
	 * 获取：艺术介绍
	 */

    public void setYishuContent(String yishuContent) {
        this.yishuContent = yishuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYishuDelete() {
        return yishuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYishuDelete(Integer yishuDelete) {
        this.yishuDelete = yishuDelete;
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

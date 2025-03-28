package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZuozheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 作者
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zuozhe")
public class ZuozheView extends ZuozheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 作者类型的值
	*/
	@ColumnInfo(comment="作者类型的字典表值",type="varchar(200)")
	private String zuozheValue;




	public ZuozheView() {

	}

	public ZuozheView(ZuozheEntity zuozheEntity) {
		try {
			BeanUtils.copyProperties(this, zuozheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "ZuozheView{" +
			", zuozheValue=" + zuozheValue +
			"} " + super.toString();
	}
}

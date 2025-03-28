package com.dao;

import com.entity.YishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YishuView;

/**
 * 艺术信息 Dao 接口
 *
 * @author 
 */
public interface YishuDao extends BaseMapper<YishuEntity> {

   List<YishuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

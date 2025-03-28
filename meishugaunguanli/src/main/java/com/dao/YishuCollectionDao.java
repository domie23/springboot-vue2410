package com.dao;

import com.entity.YishuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YishuCollectionView;

/**
 * 艺术收藏 Dao 接口
 *
 * @author 
 */
public interface YishuCollectionDao extends BaseMapper<YishuCollectionEntity> {

   List<YishuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}


package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 作者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zuozhe")
public class ZuozheController {
    private static final Logger logger = LoggerFactory.getLogger(ZuozheController.class);

    private static final String TABLE_NAME = "zuozhe";

    @Autowired
    private ZuozheService zuozheService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private GongzuoService gongzuoService;//工作人员
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private SingleSeachService singleSeachService;//单页数据
    @Autowired
    private YishuService yishuService;//艺术信息
    @Autowired
    private YishuCollectionService yishuCollectionService;//艺术收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("工作人员".equals(role))
            params.put("gongzuoId",request.getSession().getAttribute("userId"));
        params.put("zuozheDeleteStart",1);params.put("zuozheDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zuozheService.queryPage(params);

        //字典表数据转换
        List<ZuozheView> list =(List<ZuozheView>)page.getList();
        for(ZuozheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuozheEntity zuozhe = zuozheService.selectById(id);
        if(zuozhe !=null){
            //entity转view
            ZuozheView view = new ZuozheView();
            BeanUtils.copyProperties( zuozhe , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZuozheEntity> queryWrapper = new EntityWrapper<ZuozheEntity>()
            .eq("zuozhe_name", zuozhe.getZuozheName())
            .eq("zuozhe_address", zuozhe.getZuozheAddress())
            .eq("zuozhe_jiangxinag", zuozhe.getZuozheJiangxinag())
            .eq("zuozhe_time", new SimpleDateFormat("yyyy-MM-dd").format(zuozhe.getZuozheTime()))
            .eq("zuozhe_types", zuozhe.getZuozheTypes())
            .eq("zuozhe_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuozheEntity zuozheEntity = zuozheService.selectOne(queryWrapper);
        if(zuozheEntity==null){
            zuozhe.setZuozheDelete(1);
            zuozhe.setInsertTime(new Date());
            zuozhe.setCreateTime(new Date());
            zuozheService.insert(zuozhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());
        ZuozheEntity oldZuozheEntity = zuozheService.selectById(zuozhe.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zuozhe.getZuozhePhoto()) || "null".equals(zuozhe.getZuozhePhoto())){
                zuozhe.setZuozhePhoto(null);
        }
        if("".equals(zuozhe.getZuozheContent()) || "null".equals(zuozhe.getZuozheContent())){
                zuozhe.setZuozheContent(null);
        }

            zuozheService.updateById(zuozhe);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZuozheEntity> oldZuozheList =zuozheService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZuozheEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZuozheEntity zuozheEntity = new ZuozheEntity();
            zuozheEntity.setId(id);
            zuozheEntity.setZuozheDelete(2);
            list.add(zuozheEntity);
        }
        if(list != null && list.size() >0){
            zuozheService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZuozheEntity> zuozheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZuozheEntity zuozheEntity = new ZuozheEntity();
//                            zuozheEntity.setZuozheName(data.get(0));                    //作者名称 要改的
//                            zuozheEntity.setZuozheUuidNumber(data.get(0));                    //作者编号 要改的
//                            zuozheEntity.setZuozhePhoto("");//详情和图片
//                            zuozheEntity.setZuozheAddress(data.get(0));                    //作者地点 要改的
//                            zuozheEntity.setZuozheJiangxinag(data.get(0));                    //获得奖项 要改的
//                            zuozheEntity.setZuozheTime(sdf.parse(data.get(0)));          //生年 要改的
//                            zuozheEntity.setZuozheTypes(Integer.valueOf(data.get(0)));   //作者类型 要改的
//                            zuozheEntity.setZuozheContent("");//详情和图片
//                            zuozheEntity.setZuozheDelete(1);//逻辑删除字段
//                            zuozheEntity.setInsertTime(date);//时间
//                            zuozheEntity.setCreateTime(date);//时间
                            zuozheList.add(zuozheEntity);


                            //把要查询是否重复的字段放入map中
                                //作者编号
                                if(seachFields.containsKey("zuozheUuidNumber")){
                                    List<String> zuozheUuidNumber = seachFields.get("zuozheUuidNumber");
                                    zuozheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zuozheUuidNumber = new ArrayList<>();
                                    zuozheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zuozheUuidNumber",zuozheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //作者编号
                        List<ZuozheEntity> zuozheEntities_zuozheUuidNumber = zuozheService.selectList(new EntityWrapper<ZuozheEntity>().in("zuozhe_uuid_number", seachFields.get("zuozheUuidNumber")).eq("zuozhe_delete", 1));
                        if(zuozheEntities_zuozheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZuozheEntity s:zuozheEntities_zuozheUuidNumber){
                                repeatFields.add(s.getZuozheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [作者编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zuozheService.insertBatch(zuozheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zuozheService.queryPage(params);

        //字典表数据转换
        List<ZuozheView> list =(List<ZuozheView>)page.getList();
        for(ZuozheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZuozheEntity zuozhe = zuozheService.selectById(id);
            if(zuozhe !=null){


                //entity转view
                ZuozheView view = new ZuozheView();
                BeanUtils.copyProperties( zuozhe , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZuozheEntity zuozhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zuozhe:{}",this.getClass().getName(),zuozhe.toString());
        Wrapper<ZuozheEntity> queryWrapper = new EntityWrapper<ZuozheEntity>()
            .eq("zuozhe_name", zuozhe.getZuozheName())
            .eq("zuozhe_uuid_number", zuozhe.getZuozheUuidNumber())
            .eq("zuozhe_address", zuozhe.getZuozheAddress())
            .eq("zuozhe_jiangxinag", zuozhe.getZuozheJiangxinag())
            .eq("zuozhe_types", zuozhe.getZuozheTypes())
            .eq("zuozhe_delete", zuozhe.getZuozheDelete())
//            .notIn("zuozhe_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZuozheEntity zuozheEntity = zuozheService.selectOne(queryWrapper);
        if(zuozheEntity==null){
            zuozhe.setZuozheDelete(1);
            zuozhe.setInsertTime(new Date());
            zuozhe.setCreateTime(new Date());
        zuozheService.insert(zuozhe);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}


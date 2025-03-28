
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
 * 艺术信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yishu")
public class YishuController {
    private static final Logger logger = LoggerFactory.getLogger(YishuController.class);

    private static final String TABLE_NAME = "yishu";

    @Autowired
    private YishuService yishuService;


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
    private YishuCollectionService yishuCollectionService;//艺术收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZuozheService zuozheService;//作者
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
        params.put("yishuDeleteStart",1);params.put("yishuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yishuService.queryPage(params);

        //字典表数据转换
        List<YishuView> list =(List<YishuView>)page.getList();
        for(YishuView c:list){
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
        YishuEntity yishu = yishuService.selectById(id);
        if(yishu !=null){
            //entity转view
            YishuView view = new YishuView();
            BeanUtils.copyProperties( yishu , view );//把实体数据重构到view中
            //级联表 作者
            //级联表
            ZuozheEntity zuozhe = zuozheService.selectById(yishu.getZuozheId());
            if(zuozhe != null){
            BeanUtils.copyProperties( zuozhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZuozheId(zuozhe.getId());
            }
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
    public R save(@RequestBody YishuEntity yishu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yishu:{}",this.getClass().getName(),yishu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YishuEntity> queryWrapper = new EntityWrapper<YishuEntity>()
            .eq("zuozhe_id", yishu.getZuozheId())
            .eq("yishu_name", yishu.getYishuName())
            .eq("yishu_address", yishu.getYishuAddress())
            .eq("zan_number", yishu.getZanNumber())
            .eq("cai_number", yishu.getCaiNumber())
            .eq("yishu_types", yishu.getYishuTypes())
            .eq("yishu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishuEntity yishuEntity = yishuService.selectOne(queryWrapper);
        if(yishuEntity==null){
            yishu.setZanNumber(1);
            yishu.setCaiNumber(1);
            yishu.setYishuClicknum(1);
            yishu.setYishuDelete(1);
            yishu.setInsertTime(new Date());
            yishu.setCreateTime(new Date());
            yishuService.insert(yishu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YishuEntity yishu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yishu:{}",this.getClass().getName(),yishu.toString());
        YishuEntity oldYishuEntity = yishuService.selectById(yishu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yishu.getYishuPhoto()) || "null".equals(yishu.getYishuPhoto())){
                yishu.setYishuPhoto(null);
        }
        if("".equals(yishu.getYishuContent()) || "null".equals(yishu.getYishuContent())){
                yishu.setYishuContent(null);
        }

            yishuService.updateById(yishu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YishuEntity> oldYishuList =yishuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YishuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YishuEntity yishuEntity = new YishuEntity();
            yishuEntity.setId(id);
            yishuEntity.setYishuDelete(2);
            list.add(yishuEntity);
        }
        if(list != null && list.size() >0){
            yishuService.updateBatchById(list);
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
            List<YishuEntity> yishuList = new ArrayList<>();//上传的东西
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
                            YishuEntity yishuEntity = new YishuEntity();
//                            yishuEntity.setZuozheId(Integer.valueOf(data.get(0)));   //作者 要改的
//                            yishuEntity.setYishuName(data.get(0));                    //艺术名称 要改的
//                            yishuEntity.setYishuUuidNumber(data.get(0));                    //艺术编号 要改的
//                            yishuEntity.setYishuPhoto("");//详情和图片
//                            yishuEntity.setYishuAddress(data.get(0));                    //艺术地点 要改的
//                            yishuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            yishuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            yishuEntity.setYishuTypes(Integer.valueOf(data.get(0)));   //艺术类型 要改的
//                            yishuEntity.setYishuClicknum(Integer.valueOf(data.get(0)));   //艺术热度 要改的
//                            yishuEntity.setYishuContent("");//详情和图片
//                            yishuEntity.setYishuDelete(1);//逻辑删除字段
//                            yishuEntity.setInsertTime(date);//时间
//                            yishuEntity.setCreateTime(date);//时间
                            yishuList.add(yishuEntity);


                            //把要查询是否重复的字段放入map中
                                //艺术编号
                                if(seachFields.containsKey("yishuUuidNumber")){
                                    List<String> yishuUuidNumber = seachFields.get("yishuUuidNumber");
                                    yishuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yishuUuidNumber = new ArrayList<>();
                                    yishuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yishuUuidNumber",yishuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //艺术编号
                        List<YishuEntity> yishuEntities_yishuUuidNumber = yishuService.selectList(new EntityWrapper<YishuEntity>().in("yishu_uuid_number", seachFields.get("yishuUuidNumber")).eq("yishu_delete", 1));
                        if(yishuEntities_yishuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YishuEntity s:yishuEntities_yishuUuidNumber){
                                repeatFields.add(s.getYishuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [艺术编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yishuService.insertBatch(yishuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<YishuView> returnYishuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("yishuYesnoTypes",2);
        PageUtils pageUtils = yishuCollectionService.queryPage(params1);
        List<YishuCollectionView> collectionViewsList =(List<YishuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YishuCollectionView collectionView:collectionViewsList){
            Integer yishuTypes = collectionView.getYishuTypes();
            if(typeMap.containsKey(yishuTypes)){
                typeMap.put(yishuTypes,typeMap.get(yishuTypes)+1);
            }else{
                typeMap.put(yishuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yishuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("yishuYesnoTypes",2);
            PageUtils pageUtils1 = yishuService.queryPage(params2);
            List<YishuView> yishuViewList =(List<YishuView>)pageUtils1.getList();
            returnYishuViewList.addAll(yishuViewList);
            if(returnYishuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("yishuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yishuService.queryPage(params);
        if(returnYishuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYishuViewList.size();//要添加的数量
            List<YishuView> yishuViewList =(List<YishuView>)page.getList();
            for(YishuView yishuView:yishuViewList){
                Boolean addFlag = true;
                for(YishuView returnYishuView:returnYishuViewList){
                    if(returnYishuView.getId().intValue() ==yishuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYishuViewList.add(yishuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYishuViewList = returnYishuViewList.subList(0, limit);
        }

        for(YishuView c:returnYishuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYishuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yishuService.queryPage(params);

        //字典表数据转换
        List<YishuView> list =(List<YishuView>)page.getList();
        for(YishuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishuEntity yishu = yishuService.selectById(id);
            if(yishu !=null){

                //点击数量加1
                yishu.setYishuClicknum(yishu.getYishuClicknum()+1);
                yishuService.updateById(yishu);

                //entity转view
                YishuView view = new YishuView();
                BeanUtils.copyProperties( yishu , view );//把实体数据重构到view中

                //级联表
                    ZuozheEntity zuozhe = zuozheService.selectById(yishu.getZuozheId());
                if(zuozhe != null){
                    BeanUtils.copyProperties( zuozhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZuozheId(zuozhe.getId());
                }
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
    public R add(@RequestBody YishuEntity yishu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yishu:{}",this.getClass().getName(),yishu.toString());
        Wrapper<YishuEntity> queryWrapper = new EntityWrapper<YishuEntity>()
            .eq("zuozhe_id", yishu.getZuozheId())
            .eq("yishu_name", yishu.getYishuName())
            .eq("yishu_uuid_number", yishu.getYishuUuidNumber())
            .eq("yishu_address", yishu.getYishuAddress())
            .eq("zan_number", yishu.getZanNumber())
            .eq("cai_number", yishu.getCaiNumber())
            .eq("yishu_types", yishu.getYishuTypes())
            .eq("yishu_clicknum", yishu.getYishuClicknum())
            .eq("yishu_delete", yishu.getYishuDelete())
//            .notIn("yishu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishuEntity yishuEntity = yishuService.selectOne(queryWrapper);
        if(yishuEntity==null){
                yishu.setZanNumber(1);
                yishu.setCaiNumber(1);
            yishu.setYishuClicknum(1);
            yishu.setYishuDelete(1);
            yishu.setInsertTime(new Date());
            yishu.setCreateTime(new Date());
        yishuService.insert(yishu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}


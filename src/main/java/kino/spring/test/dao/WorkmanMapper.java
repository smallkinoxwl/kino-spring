package kino.spring.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface WorkmanMapper {
    
    //用户基本信息
    List<Map<String, Object>> getWorkmanInfo(@Param("phoneList") List<String> phoneList);
    
    //用户图片信息
    List<Map<String, Object>> getWorkmanImgs(@Param("phoneList") List<String> phoneList);
    
    //全部有效工种类目
    List<String> getTypeAll();
    
    //查询帖子详情(图片和对应文本) 用户 或工人
    List<Map<String, Object>> getWorkmanPostInfo(Map<String, Object> phoneInfo);
    
    //查询帖子对应的评论
    List<Map<String,Object>> getCommnetInfo(int essayRelationId);
}

package kino.spring.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface WorkmanMapper {
    
    //用户基本信息
    List<Map<String, Object>> getWorkmanInfo();
    
    //用户图片信息
    List<Map<String, Object>> getWorkmanImgs(@Param("phoneList") List<String> phoneList);
}

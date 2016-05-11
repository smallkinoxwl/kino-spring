package kino.spring.test.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface WorkmanService {

	/**
	 * 获取工人最近动态
	 * @param i
	 * @param s
	 * @return
	 */
	public List<Map<String, Object>> getWorkmanInfo(int i,String s);
	
	/**
	 * 全部有效工种类目
	 * @return
	 */
	public List<String> getTypeAll();
	
	/**
	 * 查询帖子详情(图片和对应文本) 用户 或工人
	 * @param phone :电话号码
	 * @param essayRelationId ：帖子id
	 * @return
	 */
	public Map<String, Object> getWorkmanOrUserPostInfo(String phone,int essayRelationId);
	
    /**
     * 查询帖子对应的评论
     * @return
     */
    public List<Map<String,Object>>  getCommnetInfo(int essayRelationId);
    
    /**
     * 获取工人的基本信息
     * @param phone
     * @return
     */
    public Map<String, Object> getWorkmanBasicInfo(String phone);
    
    /**
     * 查询工人详情 帖子列表
     * @param phone
     * @return
     */
    public List<Map<String,Object>> getWorkmanListInfo(String phone);
    
    /**
     * 插入帖子关联表信息
     * @param map
     * @return
     */
    public int addEssayRelation(String phone,double price,int type,String work_type,String theme,String Accuracy,String dimension,String address);
    
    /**
     * 插入帖子图片
     * @param list
     * @return
     */
    public int addEssay(List<Map<String, Object>> list);
    
    /**
     * 添加任务
     * @param map
     * @return
     */
    int addStack(Double price,String tack,String task_address,String start_time,String end_time);
    
}

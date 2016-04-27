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
}

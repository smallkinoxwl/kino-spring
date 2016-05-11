package kino.spring.test.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	/**
	 * 用户登录
	 * @param phone :电话
	 * @param password :密码
	 * @return 0：账号不存在, 2：密码错误, 3：正确
	 */
	int userlanding(String phone,String password);
	
	/**
	 * 用户注册
	 * @param map
	 * @return 1：手机号已经存在 2： 注册成功
	 */
	int insertUser(String phone,String password,String code);
	
	/**
	 * 身边用户分享帖子列表
	 * @return
	 */
	public 	List<Map<String, Object>> getUserShare();
	
	/**
	 * 查询用户分享 或 悬赏文章信息 
	 * @return
	 */
	public List<Map<String, Object>> getUserShareEssay(String phone,int start,int end);
	
	
	/**
	 * 文章对应的图片
	 * @param essayRelationIds
	 * @return
	 */
	public List<Map<String, Object>> getUserShareEssayImg(List<Object> essayRelationIds);
	
	/**
	 * 查询文章对应的最近两条评论
	 * @param essayRelationId
	 * @return
	 */
	public 	List<Map<String, Object>> getCommentInfo(String essayRelationId);
	
	/**
	 * 获取悬赏文章
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getRewardInfo(Map<String, Object> map);
	
	/**
	 * 查询图片数量
	 * @param essayRelationId
	 * @return
	 */
	public int getImgsNumber(String essayRelationId);
	
	
	/**
	 * 查询用户悬赏有多少人可以接单
	 * @param essayRelationId
	 * @return
	 */
	public List<Map<String, Object>> getEssayRelationWorkman(String essayRelationId);
	
	
	/**
	 * 查询用户悬赏文章的接单人信息
	 * @param essayRelationId
	 * @return
	 */
	public Map<String, Object> getRewardWorkmanInfo(String essayRelationId);
	
	/**
	 * 查询用户关注的工人信息 
	 * @param phone :用户电话
	 * @return
	 */
	public List<Map<String, Object>> getFollowInfo(String phone);
}
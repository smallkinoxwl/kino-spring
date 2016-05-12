package kino.spring.test.dao;


import java.util.List;
import java.util.Map;


/**
 * 
 * 用户操作接口<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 下午7:44:40
 * @version 1.0
 * @since JDK 1.7
 */
public interface UserMapper{
	
	/**
	 * 用户登录
	 * @param map
	 * @return
	 */
	int userlanding(Map<String, Object> map);
	
	/**
	 * 电话是否存在
	 * @param phone ：电话
	 * @return
	 */
	int getPhoneStatus(String phone);
	
	/**
	 * 用户注册
	 * @param map
	 * @return
	 */
	int insertUser(Map<String, Object> map);
	
	/**
	 * 
	 * 用户分享帖子列表
	 * @author 谢维林
	 * @date: 2016年4月21日 下午7:59:52
	 * @version 1.0
	 * @param id 用户id
	 * @return
	 */
	List<Map<String, Object>> getUserShare();
	
	/**
	 * 
	 * 查询用户分享 或 悬赏文章信息 
	 * @author 谢维林
	 * @date: 2016年5月21日 下午7:59:52
	 * @version 1.0
	 * @param {phone:111,type:1}
	 * @return
	 */
	List<Map<String, Object>> getUserShareEssay(Map<String, Object> map);
	
	/**
	 * 查询文章对应图片
	 * @author 谢维林
	 * @date: 2016年5月19日 下午22:59:52
	 * @version 1.0
	 * @param essayRelationIds:文章id集合
	 * @return
	 */
	List<Map<String, Object>> getUserShareEssayImg(List<Object> essayRelationIds);
	
	/**
	 *  获取文章最近的两条评论
	 *  @author 谢维林
	 *  @date: 2016年5月11日 下午22:59:52
	 *  @param essayRelationIds:文章id
	 *  @return
	 */
	List<Map<String, Object>> getCommentInfo(String essayRelationId);
	
	/**
	 * 获取悬赏文章
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getRewardInfo(Map<String, Object> map);
	
	/**
	 * 查询图片数量
	 * @param essayRelationId
	 * @return
	 */
	int getImgsNumber(String essayRelationId);
	
	/**
	 * 查询用户悬赏文章的接单人信息 
	 * @param essayRelationId
	 * @return
	 */
	List<Map<String, Object>> getEssayRelationWorkman(String essayRelationId);
	
	/**
	 * 查询用户悬赏文章的接单人信息
	 * @param essayRelationId
	 * @return
	 */
	Map<String, Object> getRewardWorkmanInfo(String essayRelationId);
	
	/**
	 * 查询关注数量
	 * @param phone :用户电话
	 * @return
	 */
	int getFollowNum(String phone);

	/**
	 * 查询用户关注的工人信息 
	 * @param phone :用户电话
	 * @return
	 */
	List<Map<String, Object>> getFollowInfo(String phone);

	/**
	 * 查询悬赏 分享 数量
	 * @param map[phone:111,type:1] 1：悬赏 2 分享
	 * @return
	 */
	int getEssayNum(Map<String, Object> map);
	
	/**
	 * 查询用户地址
	 * @param phone
	 * @return
	 */
	List<Object> getUserAddress(String phone);
}

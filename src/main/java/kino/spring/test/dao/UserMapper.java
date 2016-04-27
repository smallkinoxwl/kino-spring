package kino.spring.test.dao;


import java.util.List;
import java.util.Map;

import kino.spring.test.model.User;

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
	 * 
	 * 用户分享帖子列表
	 * 
	 * @author 谢维林
	 * @date: 2016年4月21日 下午7:59:52
	 * @version 1.0
	 * @param id 用户id
	 * @return
	 */
	List<Map<String, Object>> getUserShare();
}

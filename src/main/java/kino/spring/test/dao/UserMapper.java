package kino.spring.test.dao;

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
	 * 根据用户id查询用户. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月21日 下午7:59:52
	 * @version 1.0
	 *
	 * @param id 用户id
	 * @return
	 */
	User selectUserById(Long id);
}

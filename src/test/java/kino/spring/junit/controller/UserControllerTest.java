package kino.spring.junit.controller;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import kino.spring.junit.common.TestAbstractJunit;
import kino.spring.test.mvc.UserController;

/**
 * 
 * 用户测试类
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 下午8:07:38
 * @version 1.0
 * @since JDK 1.7
 */
public class UserControllerTest extends TestAbstractJunit {
	
	@Autowired
	private UserController userController;

	
	@Test
	public void testGetUserShare(){
		System.out.println(userController.getUserShare(null));
	}
	
	
	@Test
	public void testGetShare(){
		System.out.println(userController.getShare(null, 111+"", 0, 10));
	}
	
	@Test
	public void testGetRewardInfo(){
		System.out.println(userController.getRewardInfo(null, "111", "1", 0, 10));
	}
	
	@Test
	public void testGetFollowInfo(){
		System.out.println(userController.getFollowInfo("18683506215"));
	}
	
	@Test
	public void testGetUserInfoNum(){
		System.out.println(userController.getUserInfoNum("18683506215"));
	}
}

package kino.spring.junit.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import kino.spring.junit.common.TestAbstractJunit;
import kino.spring.test.mvc.service.impl.UserServiceImpl;

/**
 * 
 * 用户测试类
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 下午8:07:38
 * @version 1.0
 * @since JDK 1.7
 */
public class UserServiceTest extends TestAbstractJunit {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	@Test
	public void testgetWorkmanInfo(){
		System.out.println(userServiceImpl.getUserShare());
	}
	

	
	
}

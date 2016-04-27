package kino.spring.junit.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import kino.spring.junit.common.TestAbstractJunit;
import kino.spring.test.mvc.WorkmanController;

/**
 * 
 * 用户测试类
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 下午8:07:38
 * @version 1.0
 * @since JDK 1.7
 */
public class WorkmanControllerTest extends TestAbstractJunit {
	
	@Autowired
	private WorkmanController workmanController;

	
	@Test
	public void testGetTypeAll(){
		System.out.println(workmanController.getTypeAll(null));
	}
	
	@Test
	public void testGetWorkmanInfo(){
		System.out.println(workmanController.getWorkmanInfo(null));
	}
	
	@Test
	public void testGetWorkmanOrUserPostInfo(){
		System.out.println(workmanController.getWorkmanOrUserPostInfo(null, "111",1));
	}
	
}

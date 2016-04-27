package kino.spring.junit.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import kino.spring.junit.common.TestAbstractJunit;
import kino.spring.test.dao.UserMapper;
import kino.spring.test.dao.WorkmanMapper;
import kino.spring.test.model.User;
import kino.spring.test.mvc.service.impl.UserServiceImpl;
import kino.spring.test.mvc.service.impl.WorkmanServiceImpl;

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

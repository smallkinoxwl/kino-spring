package kino.spring.junit.dao;

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

/**
 * 
 * 用户测试类
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 下午8:07:38
 * @version 1.0
 * @since JDK 1.7
 */
public class UserTest extends TestAbstractJunit {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WorkmanMapper workmanMapper;
	/**
	 * 
	 * 测试根据id查询用户. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月21日 下午8:13:14
	 * @version 1.0
	 *
	 */
	@Test
	public void testSelectUserById(){
		Long id = 1l;
		User user = userMapper.selectUserById(id);
		logger.info(JSON.toJSONString(user));
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testGetWorkmanInfo(){
		System.out.println(workmanMapper.getWorkmanInfo());
	}
	
	@Test
	public void testGetWorkmanImgs(){
		List<String> phoneList = new ArrayList<String>();
		phoneList.add(111+"");
		phoneList.add(222+"");
		System.out.println(workmanMapper.getWorkmanImgs(phoneList));
	}
	
	
}

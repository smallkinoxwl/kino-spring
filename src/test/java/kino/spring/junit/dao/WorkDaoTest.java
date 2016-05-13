package kino.spring.junit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class WorkDaoTest extends TestAbstractJunit {
	
	
	@Autowired
	private WorkmanMapper workmanMapper;
	
	@Test
	public void testGetWorkmanInfo(){
		List<String> list = new ArrayList<String>();
		list.add(111+"");
		System.out.println(workmanMapper.getWorkmanInfo(list));
	}
	
	@Test
	public void testGetWorkmanImgs(){
		List<String> phoneList = new ArrayList<String>();
		phoneList.add(111+"");
		phoneList.add(222+"");
		System.out.println(workmanMapper.getWorkmanImgs(phoneList));
	}
	
	@Test
	public void testGetTypeAll(){
		System.out.println(workmanMapper.getTypeAll());
	}
	
	@Test
	public void testGetWorkmanPostInfo(){
		
		Map<String, Object> phoneInfo = new HashMap<String, Object>();
		phoneInfo.put("phone", "111");
		phoneInfo.put("essayRelationId", 1);
		System.out.println(workmanMapper.getWorkmanPostInfo(phoneInfo));
	}
	
	
	@Test
	public void testGetWorkmanListInfo(){
		System.out.println(10/3);
		System.out.println(workmanMapper.getWorkmanListInfo("111"));
	}
}

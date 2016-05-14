package kino.spring.junit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//		System.out.println(workmanController.getTypeAll(null));
	}
	
	@Test
	public void testGetWorkmanInfo(){
		System.out.println(workmanController.getWorkmanInfo(null));
	}
	
	@Test
	public void testGetWorkmanOrUserPostInfo(){
		System.out.println(workmanController.getWorkmanOrUserPostInfo(null, "111",1));
	}
	
	@Test
	public void testGetWorkmanDetailInfo(){
		System.out.println(workmanController.getWorkmanDetailInfo(null,"111",1));
	}
	
	@Test 
	public void testGetWorkmanHomePage(){
		System.out.println(workmanController.getWorkmanHomePage(null, "111"));
	}
	
	@Test
	public void testgetWorkmanListInfo(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		System.out.println(str);
		
		
		 long currentTime = System.currentTimeMillis();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
		 Date date1 = new Date(currentTime);
		 System.out.println(formatter.format(date1));
		 
		 
		System.out.println(workmanController.getWorkmanListInfo(null,"111"));
	}
	
	
	@Test
	public void testAddPost(){
		List<Map<String, Object>> imgContents = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", "http://www.imgs.com");
			map.put("content", "测试文章内容");
			map.put("main_picture", 1);
			imgContents.add(map);
			
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("img", "http://www.imgs2222.com");
			map1.put("content", "测试文章内容222");
			map1.put("main_picture", 0);
			imgContents.add(map1);
			
		System.out.println(workmanController.addPost(null, imgContents,"13888881234", 135, 1, "木工", "这是第一片文章", "0567567.567567", "0567567.567567", "黑龙江鸡西"));
	}
	
	
	@Test
	public void testAddStack(){ //price,tack,task_address,start_time,end_time
		System.out.println(workmanController.addStack(null,256.0,"镶地砖","北京市创阳区 传扬大厦","2016-04-11 11:26:00","2016-05-11 11:26:00"));
	}
}

package kino.spring.test.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kino.spring.test.dao.WorkmanMapper;
import kino.spring.test.mvc.service.WorkmanService;
import kino.spring.test.util.SpringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkmanServiceImpl implements WorkmanService{

	@Autowired
	private WorkmanMapper workmanMapper;

	@Autowired
	private SpringUtil springUtil;
	
	public List<Map<String, Object>> getWorkmanInfo(int i,String s) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workmanInfo = workmanMapper.getWorkmanInfo(new ArrayList<String>());
		
		//指定工人数量的电话号码
		List<String> phoneList = new ArrayList<String>(); 
		for(Map<String, Object> work : workmanInfo){
			String phone = work.get("phone").toString();
			
			Integer timelog = Integer.parseInt(work.get("update_time").toString())/3600;//更新小时
			String time = springUtil.getHour(timelog);
			work.put("update_time", time);
			phoneList.add(phone);
		}
		
		List<Map<String, Object>> workmanImgs = workmanMapper.getWorkmanImgs(phoneList);
		for(Map<String, Object> work : workmanInfo){
			String phone = work.get("phone").toString();
			List<Object> list = new ArrayList<Object>();
			
			for(Map<String, Object> img : workmanImgs){
				if(phone.equals(img.get("phone"))){
					list.add(img.get("img"));
				}
			}
			work.put("imgs", list);
		}
		
		return workmanInfo;
	}

	
	public List<String> getTypeAll(){
		return workmanMapper.getTypeAll();
	}
	
	
	public Map<String, Object> getWorkmanOrUserPostInfo(String phone,int essayRelationId){
		Map<String, Object> phoneInfo = new HashMap<String, Object>();
		phoneInfo.put("phone", phone);
		phoneInfo.put("essayRelationId", essayRelationId);
		List<Map<String, Object>> workmanPostInfo = workmanMapper.getWorkmanPostInfo(phoneInfo);
		
		List<String> list = new ArrayList<String>();
		list.add(phone);
		Map<String, Object> workmanInfo = workmanMapper.getWorkmanInfo(list).get(0);
		Integer timelog = Integer.parseInt(workmanInfo.get("update_time").toString())/3600;//更新小时
		String time = springUtil.getHour(timelog);
		workmanInfo.put("update_time", time);
		workmanInfo.put("imgToContent", workmanPostInfo);
		workmanInfo.put("followNumber", workmanInfo.get("followNumber"));
		return workmanInfo;
	}
	
	 public List<Map<String,Object>> getCommnetInfo(int essayRelationId){
		  List<Map<String, Object>> commnetInfo = workmanMapper.getCommnetInfo(essayRelationId);
		  for(Map<String, Object> comment : commnetInfo){
			  Integer timelog = Integer.parseInt(comment.get("create_time").toString())/3600;//更新小时
			  String time = springUtil.getHour(timelog);
			  comment.put("create_time", time);
		  }
		  return commnetInfo;
	 }
}

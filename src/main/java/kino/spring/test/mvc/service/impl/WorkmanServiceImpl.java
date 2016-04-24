package kino.spring.test.mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kino.spring.test.dao.WorkmanMapper;
import kino.spring.test.mvc.service.WorkmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkmanServiceImpl implements WorkmanService{

	@Autowired
	private WorkmanMapper workmanMapper;

	public List<Map<String, Object>> getWorkmanInfo(int i,String s) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workmanInfo = workmanMapper.getWorkmanInfo();
		
		
		//指定工人数量的电话号码
		List<String> phoneList = new ArrayList<String>(); 
		for(Map<String, Object> work : workmanInfo){
			String phone = work.get("phone").toString();
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

}

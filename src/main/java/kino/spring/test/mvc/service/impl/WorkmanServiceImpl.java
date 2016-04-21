package kino.spring.test.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kino.spring.test.dao.WorkmanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WorkmanServiceImpl {

	@Autowired
	private WorkmanMapper workmanMapper;

	public int getWorkmanInfo() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workmanInfo = workmanMapper.getWorkmanInfo();
		
		
		//指定工人数量的电话号码
		List<String> phoneList = new ArrayList<String>(); 
		for(Map<String, Object> work : workmanInfo){
			String phone = work.get("phone").toString();
			phoneList.add(phone);
		}
		
		List<Map<String, Object>> workmanImgs = workmanMapper.getWorkmanImgs(phoneList);
		return 1;
	}

}

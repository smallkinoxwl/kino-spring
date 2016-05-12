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
	
	@Override
	public List<Map<String, Object>> getWorkmanInfo() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> workmanInfo = workmanMapper.getWorkmanInfo(new ArrayList<String>());
		
		//电话号码
		List<String> phoneList = new ArrayList<String>(); 
		for(Map<String, Object> work : workmanInfo){
			String phone = work.get("phone").toString();
			
			Integer timelog = Integer.parseInt(work.get("update_time").toString())/3600;//更新时间对应的小时转换
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

	@Override
	public List<String> getTypeAll(){
		return workmanMapper.getTypeAll();
	}
	
	@Override
	public Map<String, Object> getWorkmanOrUserPostInfo(String phone,int essayRelationId){
		Map<String, Object> phoneInfo = new HashMap<String, Object>();
		phoneInfo.put("phone", phone);
		phoneInfo.put("essayRelationId", essayRelationId);
		List<Map<String, Object>> workmanPostInfo = workmanMapper.getWorkmanPostInfo(phoneInfo);
		
		List<String> list = new ArrayList<String>();
		list.add(phone);
		Map<String, Object> workmanInfo = workmanMapper.getWorkmanInfo(list).get(0);
		Integer timelog = Integer.parseInt(workmanInfo.get("update_time").toString());//更新时间转为秒
		String time = springUtil.getHour(timelog);
		workmanInfo.put("update_time", time);
		workmanInfo.put("imgToContent", workmanPostInfo);
		workmanInfo.put("followNumber", workmanInfo.get("followNumber"));
		return workmanInfo;
	}
	
	@Override
	 public List<Map<String,Object>> getCommnetInfo(int essayRelationId){
		  List<Map<String, Object>> commnetInfo = workmanMapper.getCommnetInfo(essayRelationId);
		  for(Map<String, Object> comment : commnetInfo){
			  Integer timelog = Integer.parseInt(comment.get("create_time").toString());//更新时间转为秒
			  String time = springUtil.getHour(timelog);
			  comment.put("create_time", time);
		  }
		  return commnetInfo;
	 }
	 
	@Override
	 public Map<String, Object> getWorkmanBasicInfo(String phone){
		 return workmanMapper.getWorkmanBasicInfo(phone);
	 }


	@Override
	public List<Map<String, Object>> getWorkmanListInfo(String phone) {
		  List<Map<String, Object>> workmanListInfo = workmanMapper.getWorkmanListInfo(phone);
		  
		  List<Map<String, Object>> workmanListImg = workmanMapper.getWorkmanListImg(phone);//查询工人详情 帖子列表的图片 结果需要赛选前三张
		  
		  for(Map<String, Object> listInof : workmanListInfo){
			  int essayRelationId = Integer.valueOf(listInof.get("essayRelationId").toString());
			  //去前三张图片
			  List<Object> list = new ArrayList<Object>();
			  
			  //帖子距离当前更新时间
			  int updateTime = Integer.valueOf(listInof.get("update_time").toString());//更新时间转为秒
			  String time = springUtil.getHour(updateTime);
			  listInof.put("update_time", time);
			  
			  for(Map<String, Object> listImg : workmanListImg){
				  int essayRelationIdTO = Integer.valueOf(listImg.get("essayRelationId").toString());
				  if(essayRelationId==essayRelationIdTO){
					  String img = listImg.get("img").toString();
					  String[] split = img.split(",");
					  int a=0;
					  for(String s : split){
						  list.add(s);
						  a++;
						  if(a==3)break;
					  }
				  }
			  }
			  listInof.put("img", list);
		  }
		  return workmanListInfo;
	}

	@Override
    public int addEssayRelation(String phone,double price,int type,String work_type,String theme,String Accuracy,String dimension,String address){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("price", price);
		map.put("type", type);
		map.put("work_type", work_type);
		map.put("theme", theme);
		map.put("Accuracy", Accuracy);
		map.put("dimension", dimension);
		map.put("address", address);
		
    	workmanMapper.addEssayRelation(map);
    	int id = Integer.valueOf(map.get("id").toString());
    	return id;
    }
	
	@Override
	public int addEssay(List<Map<String, Object>> list){
		return workmanMapper.addEssay(list);
	}
	
	@Override
    public int addStack(Double price,String task,String task_address,String start_time,String day){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("price", price);
		map.put("task", task);
		map.put("task_address", task_address);
		map.put("start_time", start_time);
		map.put("day", day);
		return workmanMapper.addStack(map);
	}
	
}

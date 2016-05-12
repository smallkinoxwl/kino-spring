package kino.spring.test.mvc.service.impl;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kino.spring.test.dao.UserMapper;
import kino.spring.test.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public 	List<Map<String, Object>> getUserShare(){
		return userMapper.getUserShare();
	}
	
	public List<Map<String, Object>> getUserShareEssay(String phone,int start,int end){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("start", start);
		map.put("end", end);
		return userMapper.getUserShareEssay(map);
	}
	
	public List<Map<String, Object>> getUserShareEssayImg(List<Object> essayRelationIds){
		return userMapper.getUserShareEssayImg(essayRelationIds);
	}

	@Override
	public List<Map<String, Object>> getCommentInfo(String essayRelationId) {
		return userMapper.getCommentInfo(essayRelationId);
	}
	
	@Override
	public List<Map<String, Object>> getRewardInfo(Map<String, Object> map){
		return userMapper.getRewardInfo(map);
	}

	@Override
	public int getImgsNumber(String essayRelationId) {
		return userMapper.getImgsNumber(essayRelationId);
	}

	@Override
	public List<Map<String, Object>> getEssayRelationWorkman(String essayRelationId) {
		return userMapper.getEssayRelationWorkman(essayRelationId);
	}

	@Override
	public Map<String, Object> getRewardWorkmanInfo(String essayRelationId) {
		return userMapper.getRewardWorkmanInfo(essayRelationId);
	}

	@Override
	public int userlanding(String phone,String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("password", password);
		int phoneStatus = userMapper.getPhoneStatus(phone);
		if(phoneStatus==1){
			int userlanding = userMapper.userlanding(map);
			if(userlanding==1){
				phoneStatus=3;
			}else{
				phoneStatus=2;
			}
		}
		return phoneStatus;
	}

	@Override
	public int insertUser(String phone,String password,String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("password", password);
		int phoneStatus = userMapper.getPhoneStatus(phone);
		if(phoneStatus==0){
			phoneStatus=1;
		}else{
			 userMapper.insertUser(map);
			phoneStatus=2;
		}
		return phoneStatus;
	}

	@Override
	public List<Map<String, Object>> getFollowInfo(String phone){
		return userMapper.getFollowInfo(phone);
	}

	@Override
	public Map<String, Object> getUserInfoNum(String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("type", 1);
		int essayNum = userMapper.getEssayNum(map); //查询用户悬赏文章数量
		map.put("type", 2);
		int shareNum = userMapper.getEssayNum(map);//查询用户分享文章数量
		int followNum = userMapper.getFollowNum(phone);//查询用户关注数量
		int addressNum = userMapper.getUserAddress(phone).size();//查询用户地址数量
		map.clear();
		map.put("essayNum", essayNum);
		map.put("shareNum", shareNum);
		map.put("followNum", followNum);
		map.put("addressNum", addressNum);
		return map;
	}
}
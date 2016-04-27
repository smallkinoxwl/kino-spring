package kino.spring.test.mvc.service.impl;




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
}
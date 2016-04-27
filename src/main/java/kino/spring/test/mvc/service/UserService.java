package kino.spring.test.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	
	/**
	 * 产讯用户分享帖子列表
	 * @return
	 */
	public 	List<Map<String, Object>> getUserShare();
	
}
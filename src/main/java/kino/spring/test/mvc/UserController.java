package kino.spring.test.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kino.spring.test.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="getUserShare",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserShare(HttpServletResponse  response){
		List<Map<String, Object>> userShare = userService.getUserShare();
		String info = JSON.toJSONString(userShare);
		return info;
	}
}

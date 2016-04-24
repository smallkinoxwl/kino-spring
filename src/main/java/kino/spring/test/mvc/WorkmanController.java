package kino.spring.test.mvc;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kino.spring.test.mvc.service.WorkmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/user")
public class WorkmanController {

//	@Autowired
//	private UserService userService;
	
	@Autowired
//	@Qualifier("workmanServiceImpl")
	private WorkmanService workmanService;
// 
//	@RequestMapping("getUser")
//	@ResponseBody
//	public String getUser(){
//		List<User> user = userService.getUser();
//		return "1";
//	}
	
	//@RequestMapping(value="WorkmanService",produces="text/html;charset=UTF-8")
	@RequestMapping(value="WorkmanService",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String WorkmanService(HttpServletResponse  response){
		System.out.println("WorkmanController.WorkmanService()");
		List<Map<String,Object>> workmanInfo = workmanService.getWorkmanInfo(1,"2");
		String info = JSON.toJSONString(workmanInfo);
		return info;
	}
}

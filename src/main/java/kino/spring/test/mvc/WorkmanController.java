package kino.spring.test.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kino.spring.test.mvc.service.WorkmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/workman")
public class WorkmanController {

	@Autowired
	private WorkmanService workmanService;
	
	/**
	 * 首页随机工种最新状态
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getWorkmanInfo(HttpServletResponse  response){
		List<Map<String,Object>> workmanInfo = workmanService.getWorkmanInfo(1,"2");
		String info = JSON.toJSONString(workmanInfo);
		return info;
	}
	
	/**
	 * 全部有效工种类目
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getTypeAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTypeAll(HttpServletResponse  response){
		List<String> workmanInfo = workmanService.getTypeAll();
		String info = JSON.toJSONString(workmanInfo);
		return info;
	}
	
	
	/**
	 * 查询用户 或工人帖子信息
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanOrUserPostInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getWorkmanOrUserPostInfo(HttpServletResponse  response,String phone,int essayRelationId){
		Map<String, Object> workmanOrUserPostInfo = workmanService.getWorkmanOrUserPostInfo(phone, essayRelationId);
		workmanOrUserPostInfo.put("commnet", workmanService.getCommnetInfo(essayRelationId));
		String info = JSON.toJSONString(workmanOrUserPostInfo);
		return info;
	}
}

package kino.spring.test.mvc;

import java.util.HashMap;
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
	 * 首页 首页随机工种最新状态
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
	
	
	/**
	 * 工人帖子详情页信息
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanDetailInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getWorkmanDetailInfo(HttpServletResponse  response,String phone,int essayRelationId){
		Map<String, Object> workmanOrUserPostInfo = workmanService.getWorkmanOrUserPostInfo(phone, essayRelationId);
		workmanOrUserPostInfo.put("commnet", workmanService.getCommnetInfo(essayRelationId));
		String info = JSON.toJSONString(workmanOrUserPostInfo);
		return info;
	}
	
	
	
	/**
	 * 工人主页   个人基本信息
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanHomePage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getWorkmanHomePage(HttpServletResponse  response,String phone){
		String info = JSON.toJSONString(workmanService.getWorkmanBasicInfo(phone));
		return info;
	}
	
	/**
	 * 工人主页   帖子列表信息
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="getWorkmanListInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getWorkmanListInfo(HttpServletResponse  response,String phone){
		List<Map<String, Object>> workmanListInfo = workmanService.getWorkmanListInfo(phone);
		String info = JSON.toJSONString(workmanListInfo);
		return info;
	}
	
	
	/**
	 * 用户 分享发布
	 * @param response
	 * @param imgContents
	 * @param phone
	 * @param price
	 * @param type
	 * @param work_type
	 * @param theme
	 * @param Accuracy
	 * @param dimension
	 * @param address
	 * @return
	 */
	@RequestMapping(value="addPost",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(HttpServletResponse  response,List<Map<String, Object>> imgContents,String phone,double price,int type,String work_type,String theme,String Accuracy,String dimension,String address){
		
		int essayRelationId = workmanService.addEssayRelation(phone,price,type,work_type,theme,Accuracy,dimension,address);
		for(Map<String, Object> imgContent : imgContents){
			imgContent.put("essay_relation_id", essayRelationId);
		}
		int addEssayStatis = workmanService.addEssay(imgContents);
		
		return addEssayStatis+"";
	}
	
	
	/**
	 * 工人主页 下单预约(填写 价格 地址 时间 任务 工期等。。)
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="addStack",produces="text/html;charset=UTF-8")
	@ResponseBody
	public int addStack(HttpServletResponse  response,Double price,String task,String task_address,String start_time,String day){
		return workmanService.addStack(price,task,task_address,start_time,day);
	}
	
	
	
}

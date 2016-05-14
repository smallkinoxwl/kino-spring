package kino.spring.test.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kino.spring.test.model.DataResult;
import kino.spring.test.mvc.service.WorkmanService;
import kino.spring.test.util.DataResultUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/workman")
public class WorkmanController {
	
	/**
	 * 日志
	 */
	private Logger logger = LogManager.getLogger(WorkmanController.class);

	@Autowired
	private WorkmanService workmanService;
	
	/**
	 * 全部有效工种类目
	 * @param response
	 * @return
	 */
	@RequestMapping("/getTypeAll")
	@ResponseBody
	public DataResult getTypeAll(HttpServletRequest request, HttpServletResponse response){
		try {
			List<String> workmanInfo = workmanService.getTypeAll();
			return DataResultUtil.createDataResult(true, workmanInfo, "查询成功");
		} catch (Exception e) {
			//失败打印异常
			logger.error("查询全部有效工种类目报错: ",e);
			return DataResultUtil.createDataResult(false, null, "查询全部有效工种类目失败!");
		}
	}
	
	
	/**
	 * 首页 首页随机工种最新状态
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanInfo" ,produces="application/json; charset=utf-8")
	@ResponseBody
	public String getWorkmanInfo(HttpServletResponse  response){
		List<Map<String,Object>> workmanInfo = workmanService.getWorkmanInfo();
		String info = JSON.toJSONString(workmanInfo);
		return info;
	}
	
	
	/**
	 * 查询用户 或工人帖子信息
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getWorkmanOrUserPostInfo" ,produces="application/json; charset=utf-8")
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
	@RequestMapping(value="getWorkmanDetailInfo" ,produces="application/json; charset=utf-8")
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
	@RequestMapping(value="getWorkmanHomePage" ,produces="application/json; charset=utf-8")
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
	@RequestMapping(value="getWorkmanListInfo" ,produces="application/json; charset=utf-8")
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
	@RequestMapping(value="addPost" ,produces="application/json; charset=utf-8")
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
	@RequestMapping(value="addStack" ,produces="application/json; charset=utf-8")
	@ResponseBody
	public int addStack(HttpServletResponse  response,Double price,String task,String task_address,String start_time,String day){
		return workmanService.addStack(price,task,task_address,start_time,day);
	}
	
	
	
}

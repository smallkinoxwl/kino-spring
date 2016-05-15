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
	public DataResult getTypeAll(){
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
	@RequestMapping("/getWorkmanInfo")
	@ResponseBody
	public DataResult getWorkmanInfo(){
		try{
			List<Map<String,Object>> workmanInfo = workmanService.getWorkmanInfo();
			return DataResultUtil.createDataResult(true, workmanInfo, "查询成功");
		} catch (Exception e){
			logger.error("随机工种最新状态发生错误: ",e);
			return DataResultUtil.createDataResult(false, null, "查询随机工种最新状态失败!");
		}
	}
	
	/**
	 * 工人帖子详情页信息
	 * @param response
	 * @return
	 */
	@RequestMapping("/getWorkmanDetailInfo")
	@ResponseBody
	public DataResult getWorkmanDetailInfo(String phone,int essayRelationId){
		try{
			Map<String, Object> workmanOrUserPostInfo = workmanService.getWorkmanOrUserPostInfo(phone, essayRelationId);
			workmanOrUserPostInfo.put("commnet", workmanService.getCommnetInfo(essayRelationId));
			return DataResultUtil.createDataResult(true, workmanOrUserPostInfo, "查询成功");
		} catch (Exception e){
			logger.error("工人帖子详情页信息发生错误: phone-"+phone+"essayRelationId-"+essayRelationId,e);
			return DataResultUtil.createDataResult(false, null, "查询用户 或工人帖子信息失败!");
		}
	}
	
	
	
	/**
	 * 工人主页   个人基本信息
	 * @param response
	 * @return
	 */
	@RequestMapping("/getWorkmanHomePage")
	@ResponseBody
	public DataResult getWorkmanHomePage(String phone){
		try{
			Map<String, Object> workmanBasicInfo = workmanService.getWorkmanBasicInfo(phone);
			return DataResultUtil.createDataResult(true, workmanBasicInfo, "查询成功");
		} catch (Exception e){
			logger.error("工人主页 个人基本信息发生错误: phone-"+phone,e);
			return DataResultUtil.createDataResult(false, null, "查询工人主页 个人基本信息失败!");
		}
	}
	
	/**
	 * 工人主页   帖子列表信息
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping("/getWorkmanListInfo")
	@ResponseBody
	public DataResult getWorkmanListInfo(String phone){
		try{
			List<Map<String, Object>> workmanListInfo = workmanService.getWorkmanListInfo(phone);
			return DataResultUtil.createDataResult(true, workmanListInfo, "查询成功");
		} catch (Exception e){
			logger.error("工人主页   帖子列表信息发生错误: phone-"+phone,e);
			return DataResultUtil.createDataResult(false, null, "查询工人主页帖子列表信息失败！");
		}
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
	@RequestMapping("/addPost")
	@ResponseBody
	public DataResult addPost(List<Map<String, Object>> imgContents,String phone,double price,int type,String work_type,String theme,String Accuracy,String dimension,String address){
		
		try{
			int essayRelationId = workmanService.addEssayRelation(phone,price,type,work_type,theme,Accuracy,dimension,address);
			for(Map<String, Object> imgContent : imgContents){
				imgContent.put("essay_relation_id", essayRelationId);
			}
			int addEssayStatis = workmanService.addEssay(imgContents);
			
			return DataResultUtil.createDataResult(true, addEssayStatis, "添加成功");
			
		} catch (Exception e){
			logger.error("用户 分享发布发生错误: ",e);
			return DataResultUtil.createDataResult(false, null, "用户 分享发布失败！");
		}
	}
	
	
	/**
	 * 工人主页 下单预约(填写 价格 地址 时间 任务 工期等。。)
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping("/addStack")
	@ResponseBody
	public DataResult addStack(Double price,String task,String task_address,String start_time,String day){
		try{
			int addStack = workmanService.addStack(price,task,task_address,start_time,day);
			return DataResultUtil.createDataResult(true, addStack, "查询成功");
		} catch (Exception e){
			logger.error("工人主页 下单预约发生错误",e);
			return DataResultUtil.createDataResult(false, null, "工人主页 下单预约失败!");
		}
	}
	
	
	
}

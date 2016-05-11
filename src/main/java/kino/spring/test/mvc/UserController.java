package kino.spring.test.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kino.spring.test.mvc.service.UserService;
import kino.spring.test.util.SpringUtil;

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
	
	@Autowired
	private SpringUtil springUtil;
	
	
	/**
	 * 用户登录
	 * @param phone :手机号
	 * @param password ：密码
	 * @return 0：账号不存在, 2：密码错误, 3：正确
	 */
	@RequestMapping(value="userlanding",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String userlanding(String phone,String password){
		 int userlanding = userService.userlanding(phone, password);
		 return userlanding+"";
	}
	
	
	/**
	 * 用户注册
	 * @param phone :手机号
	 * @param password ：密码
	 * @param code ：验证码
	 * @return 1：手机号已经存在 2： 注册成功
	 */
	@RequestMapping(value="insertUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertUser(String phone,String password,String code){
		int insertUser = userService.insertUser(phone, password, code);
		return insertUser+"";
	}
	
	
	/**
	 * 身边用户分享帖子列表
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getUserShare",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserShare(HttpServletResponse  response){
		List<Map<String, Object>> userShare = userService.getUserShare();
		String info = JSON.toJSONString(userShare);
		return info;
	}
	
	/**
	 * 用户分享的文章
	 * @param response
	 * @param phone ：电话
	 * @param start ：0(第一条) 
	 * @param end ：10(显示10条)
	 * @return
	 */
	@RequestMapping(value="getShare",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getShare(HttpServletResponse  response,String phone,int start,int end){
		List<Map<String, Object>> userShareEssay = userService.getUserShareEssay(phone,start,end);
		
		for(Map<String, Object> userShare : userShareEssay){
			List<Map<String, Object>> commentInfo = userService.getCommentInfo(userShare.get("essayRelationId").toString());
			String imgs = userShare.get("imgs").toString();
			List<Object> list = new ArrayList<Object>();
			String[] split = imgs.split(",");
			list.add(split[0]);
			list.add(split[1]);
			list.add(split[2]);
			
			userShare.put("createTime", springUtil.getHour(Integer.valueOf(userShare.get("createTime").toString())));
			userShare.put("comment", commentInfo);
			userShare.put("imgs", list);
		}
		
		String info = JSON.toJSONString(userShareEssay);
		return info;
	}
	
	/**
	 * 用户悬赏的文章
	 * @param response
	 * @param phone ：电话
	 * @param rewardStatus ：1悬赏中,2进行中,3待评论,4完成,5已取消
	 * @param start ：0(第一条) 
	 * @param end ：10(显示10条)
	 * @return
	 */
	@RequestMapping(value="getRewardInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getRewardInfo(HttpServletResponse  response,String phone,String rewardStatus,int start,int end){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("rewardStatus", rewardStatus);
		map.put("start", start);
		map.put("end", end);
		List<Map<String, Object>> rewardInfo = userService.getRewardInfo(map);
		List<Map<String, Object>> essayRelationWorkman = userService.getEssayRelationWorkman(phone);
		for(Map<String, Object> reward : rewardInfo){
			String essayRelationId = reward.get("essayRelationId").toString();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			for(Map<String, Object> workMan : essayRelationWorkman){
				String id = workMan.get("essayRelationId").toString();
				if(essayRelationId.equals(id)){
					list.add(workMan);
				}
			}
			reward.put("humans", list);
			reward.put("createTime", springUtil.getHour(Integer.valueOf(reward.get("createTime").toString())));
			reward.put("pictureNumber", userService.getImgsNumber(essayRelationId));
			
			if(!rewardStatus.equals(1)){
				reward.put("workmanInfo", userService.getRewardWorkmanInfo(essayRelationId));
			}
		}
		String info = JSON.toJSONString(rewardInfo);
		return info;
	}
	
	/**
	 * 查询用户关注的工人信息 
	 * @param phone :电话
	 * @return
	 */
	@RequestMapping(value="getFollowInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getFollowInfo(String phone){
		List<Map<String, Object>> followInfo = userService.getFollowInfo(phone);
		for(Map<String, Object> follow : followInfo){
			follow.put("updateTime", springUtil.getHour(Integer.valueOf(follow.get("updateTime").toString())));
		}
		String info = JSON.toJSONString(followInfo);
		return info;
	}
	
}

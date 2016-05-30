package kino.spring.test.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kino.spring.test.model.DataResult;
import kino.spring.test.mvc.service.UserService;
import kino.spring.test.util.DataResultUtil;
import kino.spring.test.util.SpringUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 日志
	 */
	private Logger logger = LogManager.getLogger(WorkmanController.class);
	
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
	@RequestMapping("/userlanding")
	@ResponseBody
	public DataResult userlanding(String phone,String password){
		 int userlanding = userService.userlanding(phone, password);
		 return  DataResultUtil.createDataResult(true, userlanding, "用户登录");
	}
	
	
	/**
	 * 用户注册
	 * @param phone :手机号
	 * @param password ：密码
	 * @param code ：验证码
	 * @return 1：手机号已经存在 2： 注册成功
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public DataResult insertUser(String phone,String password,String code){
		try{
			int insertUser = userService.insertUser(phone, password, code);
			return  DataResultUtil.createDataResult(true, insertUser, "注册成功");
		} catch (Exception e) {
			logger.error("用户注册错误: ",e);
			return DataResultUtil.createDataResult(false, null, "用户注册失败!");
		}
	}
	
	
	/**
	 * 身边用户分享帖子列表
	 * @param response
	 * @return
	 */
	@RequestMapping("/getUserShare")
	@ResponseBody
	public DataResult getUserShare(HttpServletResponse  response){
		try{
			List<Map<String, Object>> userShare = userService.getUserShare();
			return  DataResultUtil.createDataResult(true, userShare, "查询成功");
		} catch (Exception e) {
			logger.error("查询身边用户分享帖子列表发生错误: ",e);
			return DataResultUtil.createDataResult(false, null, "查询身边用户分享帖子列表失败!");
		}
	}
	
	/**
	 * 查询用户分享的文章
	 * @param response
	 * @param phone ：电话
	 * @param start ：0(第一条) 
	 * @param end ：10(显示10条)
	 * @return
	 */
	@RequestMapping("/getShare")
	@ResponseBody
	public DataResult getShare(String phone,int start,int end){
		try{
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
			return DataResultUtil.createDataResult(true, userShareEssay, "查询成功");
		} catch (Exception e) {
			logger.error("查询用户分享的文章报错: ",e);
			return DataResultUtil.createDataResult(false, null, "查询用户分享的文章 失败!");
		}
	}
	
	/**
	 * 查询用户悬赏的文章
	 * @param response
	 * @param phone ：电话
	 * @param rewardStatus ：1悬赏中,2进行中,3待评论,4完成,5已取消
	 * @param start ：0(第一条) 
	 * @param end ：10(显示10条)
	 * @return
	 */
	@RequestMapping("/getRewardInfo")
	@ResponseBody
	public DataResult getRewardInfo(String phone,String rewardStatus,int start,int end){
		try{
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
			
			return DataResultUtil.createDataResult(true, rewardInfo, "查询成功");
		} catch (Exception e) {
			logger.error("查询用户悬赏的文章 报错: ",e);
			return DataResultUtil.createDataResult(false, null, "查询用户悬赏的文章 失败!");
		}
	}
	
	/**
	 * 查询用户关注的工人信息 
	 * @param phone :电话
	 * @return
	 */
	@RequestMapping("/getFollowInfo")
	@ResponseBody
	public DataResult getFollowInfo(String phone){
		try{
			List<Map<String, Object>> followInfo = userService.getFollowInfo(phone);
			for(Map<String, Object> follow : followInfo){
				follow.put("updateTime", springUtil.getHour(Integer.valueOf(follow.get("updateTime").toString())));
			}
			return DataResultUtil.createDataResult(true, followInfo, "查询成功");	
		} catch (Exception e) {
			logger.error("查询用户关注的工人信息报错: ",e);
			return DataResultUtil.createDataResult(false, null, "查询用户关注的工人信息失败!");
		}
	}
	
	/**
	 * 获取用户个人主页 个文章信息数量 
	 * @param phone :电话
	 * @return
	 *   	"followNum": 3,   悬赏数量
     * 		"shareNum": 0,    分享数量
     * 		"essayNum": 1,    地址数量
     * 		"addressNum": 2         关注数量
	 */
	@RequestMapping("/getUserInfoNum")
	@ResponseBody
	public DataResult getUserInfoNum(String phone){
		try{
			Map<String, Object> userInfoNum = userService.getUserInfoNum(phone);
			return DataResultUtil.createDataResult(true, userInfoNum, "查询成功");
		} catch (Exception e) {
			logger.error("获取用户个人主页 个文章信息数量 报错: ",e);
			return DataResultUtil.createDataResult(false, null, "查询用户个人主页 个文章信息数量 失败!");
		}
	}
	
	/**
	 * 我的  获取用户个人信息 
	 * @param phone
	 * @return
  	 *		"sex": 1,  1男 2女
     *		"phone": "18683506215", 电话
     *		"name": "大大的太阳",  昵称
     *		"head_img": "http://banbao.chazidian.com/uploadfile/2016-01-25/s145368924044608.jpg" 头像
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public DataResult getUserInfo(String phone){
		try{
			Map<String, Object> userInfo = userService.getUserInfo(phone);
			return DataResultUtil.createDataResult(true, userInfo, "查询成功");
		} catch (Exception e) {
			logger.error("获取用户个人信息  报错: ",e);
			return DataResultUtil.createDataResult(false, null, "获取用户个人信息  失败!");
		}
	}
	
	/**
	 * 用户点赞
	 * @param phone : 电话
	 * @param essayRelationId ： 文章id
	 * @return 1：点赞成功 2：以前点赞过
	 */
	public DataResult addLinkNum(String phone,int essayRelationId){
		try{
			int status = userService.addLinkNum(phone,essayRelationId);
			return DataResultUtil.createDataResult(true, status, "添加成功");
		} catch (Exception e) {
			logger.error("用户点赞  报错: ",e);
			return DataResultUtil.createDataResult(false, null, "用户点赞  失败!");
		}
	}
	
	/**
	 * 添加评论
	 * @param commentText ：评论内容
	 * @param essayRelationId ：文章id
	 * @param userId ：用户id
	 * @param commentId ：评论id
	 * @param headImg ：用户头像图片
	 * @param name ：昵称
	 * @param replyName ：回复对象人 昵称
	 * @return
	 */
	public DataResult addComment(String commentText,String essayRelationId,String userId, String commentId,String headImg,String name, String replyName){
		try{
			int status = userService.addCommentInfo(commentText,essayRelationId,userId,commentId,headImg,name,replyName);
			return DataResultUtil.createDataResult(true, status, "添加成功");
		} catch (Exception e) {
			logger.error("添加评论  报错: ",e);
			return DataResultUtil.createDataResult(false, null, "添加评论  失败!");
		}
	}
	
	
	
}

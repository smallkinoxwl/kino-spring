package kino.spring.test.util;

import org.springframework.stereotype.Service;

@Service
public class SpringUtil {

	
	/**
	 * 获取距离当前时间 转换成小时 或 天数
	 * @param timelog (小时)
	 * @return
	 */
	public String getHour(int timelog){
		long timeNew = System.currentTimeMillis()/1000/3600; //当前小时
		int times = (int) (timeNew-timelog);
		String time = "";
		times=times/24;
		if(times>24){
			time=times+"天前";
		}else{
			time=times+"小时前";
		}
		return time;
	}
	
	
}

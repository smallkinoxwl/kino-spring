package kino.spring.test.util;

import org.springframework.stereotype.Service;

@Service
public class SpringUtil {

	
	/**
	 * 获取距离当前时间 转换成 分钟 或 小时 或 天数
	 * @param timelog (小时)
	 * @return
	 */
	public String getHour(int timelog){
		long timeNew = System.currentTimeMillis()/1000/60; //当前分钟
		int times = (int) (timeNew-timelog/60);//相距分钟
		String time = "";
		int number = (times/60);//小时
		if(times<60){
			time=times+"分钟前";
		}else if(number>=1 && number<24){
			time=number+"小时前";
		}else if(number>24 && number<720){
			time=number/24+"天前";
		}else if(number>=720 && number<8760){
			time=number/720+"月前";
		}else if(number>=8760){
			time=number/8760+"年前";
		}
		return time;
	}
	
	
}

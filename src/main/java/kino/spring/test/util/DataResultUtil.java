package kino.spring.test.util;

import kino.spring.test.model.DataResult;

/**
 * 
 * Description: 返回数据规范化对象生成<br/>
 *
 * @author 肖晓峰
 * @date: 2016年5月14日 下午10:46:17
 * @version 1.0
 * @since JDK 1.7
 */
public class DataResultUtil {
	
	/**
	 * 
	 * TODO(这里用一句话描述这个方法的作用). <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年5月14日 下午10:50:06
	 * @version 1.0
	 *
	 * @param success 是否成功 
	 * @param data 数据
	 * @param message 提示信息
	 * @return
	 */
	public static DataResult createDataResult(Boolean success, Object data, String message){
		return new DataResult(success, data, message);
	}
	
}

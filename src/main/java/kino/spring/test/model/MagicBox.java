package kino.spring.test.model;

import java.io.Serializable;

/**
 * 
 * 魔术盒<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月27日 上午10:28:22
 * @version 1.0
 * @since JDK 1.7
 */
public class MagicBox implements Serializable{
	
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */  
	private static final long serialVersionUID = -4257471455888549235L;

	public String getContext(){
		return "a cat name Tangtang";
	}
}

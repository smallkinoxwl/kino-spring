package kino.spring.test.model;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * 
 * 基本方法注入替换<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月27日 上午10:36:12
 * @version 1.0
 * @since JDK 1.7
 */
public class MagicBoxReplace implements MethodReplacer {

	/**
	 * 替换实现
	 */
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		
		return "a cat name JiuMao";
	}

}

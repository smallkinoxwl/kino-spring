package kino.spring.junit.springInAction3;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import kino.spring.junit.common.TestAbstractJunit;

/**
 * 
 * 父类bean测试类<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月22日 下午4:15:16
 * @version 1.0
 * @since JDK 1.7
 */
public class ParentBeanTest extends TestAbstractJunit {
	
	/**
	 * 
	 * 父类继承bean测试. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月22日 下午4:16:31
	 * @version 1.0
	 *
	 */
	@Test
	public void parentBeanTest(){
		Object jimmy = applicationContext.getBean("jimmy");
		logger.info(JSON.toJSONString(jimmy));
		Assert.assertNotNull(jimmy);
	}
	
	/**
	 * 
	 * 父类覆盖属性bean测试. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月22日 下午4:16:31
	 * @version 1.0
	 *
	 */
	@Test
	public void parentCoverBeanTest(){
		Object tommy = applicationContext.getBean("tommy");
		logger.info(JSON.toJSONString(tommy));
		Assert.assertNotNull(tommy);
	}
	
	/**
	 * 
	 * 抽象属性测试. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月27日 上午10:06:09
	 * @version 1.0
	 *
	 */
	@Test
	public void abstractPropBeanTest(){
		Object wendy = applicationContext.getBean("wendy");
		logger.info(JSON.toJSONString(wendy));
		Assert.assertNotNull(wendy);
	}
	
}

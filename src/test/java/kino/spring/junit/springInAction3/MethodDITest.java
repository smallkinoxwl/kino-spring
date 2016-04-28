package kino.spring.junit.springInAction3;

import org.junit.Assert;
import org.junit.Test;

import kino.spring.junit.common.TestAbstractJunit;
import kino.spring.test.model.Magician;

/**
 * 
 * 方法注入<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月27日 上午10:40:18
 * @version 1.0
 * @since JDK 1.7
 */
public class MethodDITest extends TestAbstractJunit {
	
	/**
	 * 
	 * 基本方法注入. <br/> 
	 * 
	 * @author 肖晓峰
	 * @date: 2016年4月27日 上午10:40:56
	 * @version 1.0
	 *
	 */
	@Test
	public void basicMehodDITest(){
		Magician magician = applicationContext.getBean("magician", Magician.class);
		magician.execute();
		Assert.assertNotNull(magician);
	}
}

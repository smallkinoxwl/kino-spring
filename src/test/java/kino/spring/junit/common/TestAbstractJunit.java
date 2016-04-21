package kino.spring.junit.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 测试基类 所有测试类都继承该类<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月21日 上午10:50:13
 * @version 1.0
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/spring/spring.xml"})
public abstract class TestAbstractJunit extends AbstractJUnit4SpringContextTests {
	protected final Logger logger = LogManager.getLogger(TestAbstractJunit.class);
}

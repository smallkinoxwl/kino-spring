package kino.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import com.alibaba.fastjson.JSONObject;

@Aspect
public class AspectJLogger {
	

	/** 
     * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的 
     */  
    public static final String EDP = "execution(* kino.spring.test.mvc.service.impl.*.*(..))";  
   /*   
    @Before(EDP)    //spring中Before通知  
    public void logBefore() {  
        System.out.println("logBefore:现在时间是:"+new Date());  
    }  
      
    @After(EDP)    //spring中After通知  
    public void logAfter() {  
        System.out.println("logAfter:现在时间是:"+new Date()); 
    }  */
      
    @Around(EDP)   //spring中Around通知  
    public Object logAround(ProceedingJoinPoint joinPoint) {  
    	
    	if(joinPoint instanceof MethodInvocationProceedingJoinPoint) {
    		JSONObject result = new JSONObject();
			MethodInvocationProceedingJoinPoint method = (MethodInvocationProceedingJoinPoint) joinPoint;
			String methodName = method.getSignature().toString();
			
			result.put("methedName", methodName);
			System.out.println("methedName:"+methodName);
	        Object[] args = joinPoint.getArgs();
	        result.put("params",args);

			System.err.println("********* params ********      "+JSONObject.toJSONString(args));
	        Object obj = null; 
	        try {  
	            obj = joinPoint.proceed(args);  
	        } catch (Throwable e) {  
	            e.printStackTrace();  
	        } 
	        
	        result.put("result", JSONObject.toJSONString(obj));
			System.err.println("********* result *********      "+JSONObject.toJSONString(obj));
	        return obj;
			
		}
    	return null;

    	
    	
          
    }  
}
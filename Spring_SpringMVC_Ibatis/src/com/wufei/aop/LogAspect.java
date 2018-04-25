package com.wufei.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * @author wufei
 * 使用AOP去实现把实际的业务逻辑与每个方法都共用的逻辑分割，代码共用
 * 先简单实现下@Before @After 还有@AfterThrowing  @AfterReturning  @Around
 */
@Component
@Aspect
public class LogAspect {
	private static Log log = LogFactory.getLog(LogAspect.class);
	
	public long startTime;
	public long endTime;
	
//	TODO 表达式的解释： public 
//	方法的类型  com.wufei,service 包名  .* 表示 任何类  .*表示任何方法  (..)任何参数 
	@Pointcut(value="execution(public * com.wufei.service.*.*(..))")
	public void logPrint(){
		
	}
	
	@Before(value="logPrint()")
	public void beforeLog(){
		startTime = System.currentTimeMillis();
		log.info("系统执行任务的开始时间：" + startTime);
	}
	
	@After(value="logPrint()")
	public void afterLog(){
		endTime = System.currentTimeMillis();
		log.info("系统执行任务的结束时间：" + endTime);
		log.info("共计时间：" + (endTime-startTime) + "ms");
	}
	
}

package com.pair.nkweb.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LogAdvice {

	@AfterThrowing(pointcut = "execution(* com.pair.nkweb.*.*.*(..))", throwing = "e")
	public void logging(JoinPoint point, Throwable e) {
		
		Object[] params = point.getArgs();
		
		log.error("Exception while executing method below - ");
		log.error("[" + point.getStaticPart().getSignature() + "]");
		log.error("Exception message - " + e.getMessage());
		log.error("Full stack trace logged further below");
		
		log.error("Params for this method - ");
		
		for(Object object : params) {
			
			log.error(object == null ? "[is null]" : object.toString());
		}
	}
}

package com.mvpjava.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceVsComponentAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("@within(org.springframework.stereotype.Service)")
	public void implLogging(JoinPoint joinPoint) {
		logger.info(" Around advice matched Class [" + joinPoint.getSignature().toLongString() + "]");
	}
}

package com.mvpjava.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*@Before("execution(@org.springframework.stereotype.Service * com.mvpjava.demo.DiscounterService.*(com.mvpjava.demo.Product))")
	 * Only works for methods ans so does @annotation(org.springframework.stereotype.Service).
	 * @Service only can be placed at Class level so will not match. Have to use @within()
	 */
	//@Before("execution(* calculateDiscountFor(*)) && @within(org.springframework.stereotype.Service)")

	//@Before("execution(* calculateDiscountFor(*))")
	//@Before("execution(* com.mvpjava.*.*.*(..))")
	
	
	@Before("@within(org.springframework.stereotype.Service)")
	public void implLogging(JoinPoint joinPoint) {
        logger.info(" advice implementation - " + joinPoint.getTarget().getClass() + //
                    "; Executing before " + joinPoint.getSignature().getName() + //
                    "() method");

	}

// This reads better
//
//	@Before("allMethodsWithServiceAnnotationOnClassPointcut()")
//	public void implLogging(JoinPoint joinPoint) {
//        logger.info(" advice implementation - " + joinPoint.getTarget().getClass() + //
//                    "; Executing before " + joinPoint.getSignature().getName() + //
//                    "() method");
//	}
//	
//	@Pointcut("@within(org.springframework.stereotype.Service)")
//	public void allMethodsWithServiceAnnotationOnClassPointcut(){}
}

package com.mvpjava.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*@Before("execution(@org.springframework.stereotype.Service * com.mvpjava.demo.Discounter.*(com.mvpjava.demo.Product))")
	 * Only works for methods ans so does @annotation(org.springframework.stereotype.Service).
	 * @Service only can be placed at Class level so will not match. Have to use @within()
	 */
	@Before("execution(* *(*)) && @within(org.springframework.stereotype.Service)")
	//@Before("execution(* calculateDiscountFor(*)) && @within(org.springframework.stereotype.Service)")

	//@Before("execution(* calculateDiscountFor(*))")
	//@Before("execution(* com.mvpjava.*.*.*(..))")
	
	public void implLogging(JoinPoint joinPoint) {
        logger.info(" advice implementation - " + joinPoint.getTarget().getClass() + //
                    "; Executing before " + joinPoint.getSignature().getName() + //
                    "() method");

	}
}

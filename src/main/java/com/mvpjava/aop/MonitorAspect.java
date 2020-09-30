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

	// 1. match the DiscountGeneratorService and BootstrapCommandLineRunner and possible future additions of @Component thus we need to refine
	// @Before("@within(org.springframework.stereotype.Component)")
	// 2. more specific (harder to read, what is * again?)
	//@Before("execution(* calculateDiscountFor(*)) && @within(org.springframework.stereotype.Component)")
    // or (but more brittle since if you move Product to another package or
	// rename method or change return type to BigDecimal then it will break pointcut
	@Before("execution(double calculateDiscountFor(com.mvpjava.demo.Product)) && @within(org.springframework.stereotype.Component)")

	public void implLogging(JoinPoint joinPoint) {
        logger.info(" advice implementation - " + joinPoint.getTarget().getClass() + //
                    "; Executing before " + joinPoint.getSignature().getName() + //
                    "() method");
	}

	
//	@Before("@within(org.springframework.stereotype.Service)")
//	public void implLogging(JoinPoint joinPoint) {
//        logger.info(" advice implementation - " + joinPoint.getTarget().getClass() + //
//                    "; Executing before " + joinPoint.getSignature().getName() + //
//                    "() method");
//	}

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

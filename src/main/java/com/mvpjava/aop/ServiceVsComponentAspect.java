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

	// 1. match the DiscountGeneratorService and BootstrapCommandLineRunner and
	// possible future additions of @Component thus we need to refine
	// @Before("@within(org.springframework.stereotype.Component)")
	
	// 2. more specific (harder to read, what is * again?)
	// @Before("execution(double calculateDiscountFor(*)) &&  @within(org.springframework.stereotype.Component)")
	// or (but more brittle since if you move Product to another package or
	// rename method or change return type to BigDecimal then it will break pointcut
	// @Before("execution(double calculateDiscountFor(com.mvpjava.demo.Product)) &&  @within(org.springframework.stereotype.Component)")

	//@Before("@within(com.mvpjava.demo.TransactionalService)")
	@Before("@within(org.springframework.stereotype.Service)")
	public void implLogging(JoinPoint joinPoint) {
		logger.info(" Around advice matched Class [" + joinPoint.getSignature().toLongString() + "]");
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

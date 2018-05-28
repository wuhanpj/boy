package com.study.boy.aspect;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);
	
	/**
	 * 定义一个切入点
	 */
	@Pointcut("execution(public * com.study.boy.controller.BoyController.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
		
		//url
		log.info("url={}", request.getRequestURL());
		//method
		log.info("method={}",request.getMethod());
		//ip
		log.info("IP={}", request.getRemoteAddr());
		//类方法
		log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		//参数
		log.info("param={}", joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter() {
		log.info("22222222");
	}
	
	@AfterReturning(returning="object", pointcut="log()")
	public void doAfterReturning(Object object) {
		log.info("response={}", object.toString());
	}

}

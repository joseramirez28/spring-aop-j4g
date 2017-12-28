package org.j4g.spring.xml.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.l4g.spring.xml.model.ClientInfo;
import org.l4g.spring.xml.model.ClientStatus;

@Aspect
public class ClientAdvise {

	@Before("execution(* org.l4g.spring.xml.model.ClientInfo.printClientInfo(..))")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("[@Before] Advice executing before method...");
		System.out.println("[@Before] Method Signature: " + jp.getSignature());
		ClientInfo bean = (ClientInfo) jp.getTarget();
		int days = bean.getDaysWithoutShopping();
		System.out.println("[@Before] Target Status before advice: " + bean.getStatus());
		ClientStatus status = (days > 30) ? ClientStatus.INACTIVE : ClientStatus.ACTIVE;
		bean.setStatus(status);
	}

	@After("execution(* org.l4g.spring.xml.model.ClientInfo.printClientInfo(..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("[@After]Advice executing after method...");
		System.out.println("[@After]Method Signature: " + jp.getSignature());
		ClientInfo bean = (ClientInfo) jp.getTarget();
		System.out.println("[@After]Target Status after method: " + bean.getStatus());
	}

	@Around("execution(* org.l4g.spring.xml.model.ClientInfo.printName(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[@Around]Advice executing around method...");
		ClientInfo client = (ClientInfo) pjp.getTarget();
		client.setName("Mr/Mrs " + client.getName());
		pjp.proceed();
		System.out.println("[@Around]Advice execution around method after method execution");
	}

	@AfterReturning(pointcut = "execution(* org.l4g.spring.xml.model.ClientInfo.isClientInExpiredStatus(..))", returning = "result")
	public void afterReturningAdvice(JoinPoint jp, Object result) {
		System.out.println("[@AfterReturning]Advice executing after returning method...");
		System.out.println("[@AfterReturning] Result: " + result);
	}

	@AfterThrowing(pointcut = "execution(* org.l4g.spring.xml.model.ClientInfo.isClientInExpiredStatus(..))", throwing = "error")
	public void afterThrowingAdvice(JoinPoint jp, Throwable error) throws Exception {
		System.out.println("[@AfterThrowing]Advice executing after returning method...");
	}

}

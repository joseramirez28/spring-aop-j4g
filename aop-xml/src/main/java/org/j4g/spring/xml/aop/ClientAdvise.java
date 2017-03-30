package org.j4g.spring.xml.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.l4g.spring.xml.model.ClientInfo;
import org.l4g.spring.xml.model.ClientStatus;

public class ClientAdvise {

	public void beforeAdvice(JoinPoint jp) {
		System.out.println("[@Before] Advice executing before method...");
		System.out.println("[@Before] Method Signature: " + jp.getSignature());
		ClientInfo bean = (ClientInfo) jp.getTarget();
		int days = bean.getDaysWithoutShopping();
		System.out.println("[@Before] Target Status before advice: " + bean.getStatus());
		ClientStatus status = (days > 30) ? ClientStatus.INACTIVE : ClientStatus.ACTIVE;
		bean.setStatus(status);
	}

	public void afterAdvice(JoinPoint jp) {
		System.out.println("[@After]Advice executing after method...");
		System.out.println("[@After]Method Signature: " + jp.getSignature());
		ClientInfo bean = (ClientInfo) jp.getTarget();
		System.out.println("[@After]Target Status after method: " + bean.getStatus());
	}

	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[@Around]Advice executing around method...");
		ClientInfo client = (ClientInfo) pjp.getTarget();
		client.setName("Mr/Mrs " + client.getName());
		pjp.proceed();
		System.out.println("[@Around]Advice execution around method after method execution");
	}

	public void afterReturningAdvice(JoinPoint jp, Object result) {
		System.out.println("[@AfterReturning]Advice executing after returning method...");
		System.out.println("[@AfterReturning] Result: " + result);
	}

	public void afterThrowingAdvice(JoinPoint jp, Throwable error) throws Exception {
		System.out.println("[@AfterThrowing]Advice executing after returning method...");
	}

}

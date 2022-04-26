package com.study.calc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Around(value="execution(* com.study.calc..*(..))")
	public Object measure(ProceedingJoinPoint pjp) throws Throwable {
		// 수행전
		long start = System.nanoTime();
		
		// 메소드 호출
		try {
			Object obj = pjp.proceed();
			return obj;
		} finally {
		
		//수행 후
		long end = System.nanoTime();
		System.err.println("걸린 시간 : "+(end-start));
	
		}
	}
}

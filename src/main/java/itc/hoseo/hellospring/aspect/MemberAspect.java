package itc.hoseo.hellospring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MemberAspect {

	@Around("execution (* itc.hoseo.hellospring.service.MemberService.*(..))")
	public Object calcSave(ProceedingJoinPoint pjp) throws Throwable{
		Object result = null;
		
		long start = System.currentTimeMillis();
		long end = -1;
		
		try {
			result = pjp.proceed();
			end = System.currentTimeMillis();
		} catch (Throwable e) {
			end = System.currentTimeMillis();
			log.error("메소드 수행중 오류 발생 : {} / 수행시간 : {}"
					, pjp.getSignature().getName()
					, end - start);
			throw e;
		}
		log.info("{} 메소드 수행시간 : {}"
				,pjp.getSignature().getName() 
				,end - start);
		return result;
	}
}

package itc.hoseo.hellospring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MemberPerformance {

    @Around("execution(* itc.hoseo.hellospring.service.MemberService.join(..))")
    public void calcMemberSavePerformance(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();

        try {
            pjp.proceed();
            long end = System.currentTimeMillis();

            log.info("수행 시간 : "+ (end - start));
        } catch (Throwable throwable) {
            long end = System.currentTimeMillis();
            log.error("수행 중 오류 발생!! : {}", end - start );
        }
    }

}

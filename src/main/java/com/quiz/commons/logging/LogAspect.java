package com.quiz.commons.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * Logging 관련 처리
     * |_ 접근제한자
     * |_ 패키지
     * |_ Controller 로 끝나는 클래스
     * |_ 모든 메소
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.quiz.web.controller..*Controller.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        //todo : 어떤 값을 찍을 것인가 구현하기.!
        log.info("start - ");
        log.info("{}, {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("{}, {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
        log.info("finished");
        return result;
    }
}

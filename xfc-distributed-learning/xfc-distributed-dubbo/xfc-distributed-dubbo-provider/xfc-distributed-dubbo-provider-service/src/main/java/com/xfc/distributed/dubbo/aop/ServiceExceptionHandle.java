package com.xfc.distributed.dubbo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ServiceExceptionHandle {

    @Pointcut(value = "execution(* com.xfc.distributed.dubbo..*.*(..))")
    private void servicePointcut() {
    }

    @Before("servicePointcut()")
    private void before(JoinPoint joinPoint){

        System.out.println(joinPoint.getArgs());
    }

    @Around("servicePointcut()")
    public Object doTransactionalAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            // dubbo会将异常捕获进行打印，这里就不打印了
            // processException(pjp, args, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 处理异常
     *
     * @param joinPoint 切点
     * @param args      参数
     * @param throwable 异常
     */
    private void processException(final ProceedingJoinPoint joinPoint, final Object[] args, Throwable throwable) {
        String inputParam = "";
        if (args != null && args.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                sb.append(",");
                sb.append(arg);
            }
            inputParam = sb.toString().substring(1);
        }

//    @AfterThrowing("servicePointcut()")
//    public void

    }
}
package Rohit.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Carlogger {

    @Pointcut("execution(public * Rohit.car.*.speedUp(..))")
    public void pointCutAfterExecution() { }

    @Before("execution(* Rohit.car.*.*(..))")
    public void logBeforeAnyMethodExecCarPack(JoinPoint jp){
        System.out.println("before Excecution i am getting printed");
        System.out.println("excecuting method"+jp.getSignature());
        System.out.println("after this line you will see method output");
        System.out.println("************");
    }
    @After("pointCutAfterExecution()")
    public void  logafteranymethods(JoinPoint jp){
        System.out.println("after excecution printed");
    }
}

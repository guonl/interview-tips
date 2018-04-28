package aop.demo12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    /**
     * AspectJ execution 表达式拦截方法
     * execution(* aop.demo.GreetingImpl.*(..))
     *      execution()：表示拦截方法，括号中可定义需要匹配的规则。
     *      第一个“*”：表示方法的返回值是任意的。
     *      第二个“*”：表示匹配该类中所有的方法。
     *      (..)：表示方法的参数是任意的。
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(* aop.demo12.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}

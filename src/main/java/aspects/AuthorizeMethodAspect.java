package aspects;

import authorisation.AuthLevel;
import authorisation.Authorization;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AuthorizeMethodAspect {
    @Pointcut("@annotation(auth)")
    public void annotationPointCutDefinition(Authorization auth){
    }

    @Pointcut("execution(* *(..))")
    public void atExecution(){
    }

    @Around("annotationPointCutDefinition(auth) && atExecution()")
    public Object aroundAdvice(ProceedingJoinPoint pjp, Authorization auth) throws Throwable{
        Object returnObject = null;
        if (auth.accessLevel() == AuthLevel.ALLOWED) {
            try {
                returnObject = pjp.proceed();
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                System.out.println("A method was ignored due to authorization fail.");
            }
            return returnObject;
        }
        else if (auth.accessLevel() == AuthLevel.NOT_ALLOWED){
            return returnObject;
        }
        return returnObject;
    }
}

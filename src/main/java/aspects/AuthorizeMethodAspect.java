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
    public void callAt(Authorization auth) {}

    @Around("callAt(auth)")
    public Object around(ProceedingJoinPoint pjp, Authorization auth) throws Throwable{
        if (auth.accessLevel() == AuthLevel.ALLOWED) {
            return pjp.proceed();
        } else {
            return null;
        }
    }
}

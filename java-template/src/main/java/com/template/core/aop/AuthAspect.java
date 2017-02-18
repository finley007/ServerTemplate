package com.template.core.aop;

import com.template.core.annotation.Secured;
import com.template.core.Token;
import com.template.core.LogUtil;
import com.template.core.exception.ExceptionHandler;
import com.template.exception.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Created by finley on 2/2/17.
 */
@Component
@Aspect
public class AuthAspect {

    @Around(value="execution(* com.template.component..*.*(..)) && @annotation(secured)", argNames="secured")
    public Response authToken(ProceedingJoinPoint aPoint, Secured secured) {
        LogUtil.debug(this.getClass(), "Auth aspect handle for component: {} and service: {}",
                new Object[]{aPoint.getTarget().getClass(), aPoint.getSignature()});
        HttpServletRequest request = (HttpServletRequest)aPoint.getArgs()[0];
        String tokenKey = request.getHeader(HttpHeaders.AUTHORIZATION);
        HttpServletResponse response = (HttpServletResponse)aPoint.getArgs()[1];
        Token token = Token.touch(tokenKey);
        if (token != null) {
            try {
                return (Response)aPoint.proceed();
            } catch (Throwable throwable) {
                LogUtil.error(this.getClass(), "Execute service error: ", throwable);
            }
        }
        String res = ExceptionHandler.handle(new UnauthorizedException("Unauthorized error"));
        return Response.status(Response.Status.UNAUTHORIZED).entity(res).build();
    }

}

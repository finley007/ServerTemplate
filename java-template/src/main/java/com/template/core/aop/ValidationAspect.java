package com.template.core.aop;

import com.template.core.annotation.Validate;
import com.template.core.exception.BusinessException;
import com.template.core.log.LogUtil;
import com.template.exception.InvalidRequestException;
import com.template.exception.NullRequestException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by finley on 2/2/17.
 */
@Component
@Aspect
public class ValidationAspect {

    @Before(value="execution(* com.template..*Service.*(..)) && @annotation(validate)", argNames="validate")
    public void validate(JoinPoint aPoint, Validate validate) throws BusinessException {
        LogUtil.debug(this.getClass(), "Do validation for service: {} and action: {}",
                new Object[]{aPoint.getTarget().getClass(), aPoint.getSignature().getName()});
        Object arg = aPoint.getArgs()[0];
        if (arg == null) {
            throw new NullRequestException("The request is null");
        }
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(arg);
        if (violations.size() > 0) {
            for (ConstraintViolation violation : violations) {
                LogUtil.debug(this.getClass(), violation.getMessage());
            }
            throw new InvalidRequestException("Invalid request: " + violations.get(0).getMessage());
        }
    }

}

package com.template.auth;

import com.template.auth.AuthService;
import com.template.auth.AuthRequest;
import com.template.auth.AuthResponse;
import com.template.core.annotation.Validate;
import com.template.core.token.Token;
import com.template.core.log.LogUtil;
import com.template.exception.InvalidUserException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by finley on 1/25/17.
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Validate
    public AuthResponse authenticate(AuthRequest request) throws Exception {
        LogUtil.info(this.getClass(), "Call Shiro for authtication");
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
       // token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (Exception e) {
            LogUtil.error(this.getClass(), "Login failed: ", e);
            throw new InvalidUserException(e.getMessage());
        }
        return new AuthResponse(0, "OK", new Token(request.getUsername(), currentUser).getKey());
    }

}

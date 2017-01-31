package com.template.core.auth.impl;

import com.template.core.auth.AuthService;
import com.template.core.auth.request.AuthRequest;
import com.template.core.auth.response.AuthResponse;
import com.template.core.auth.token.Token;
import com.template.core.log.LogUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by finley on 1/25/17.
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    public AuthResponse authenticate(AuthRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
       // token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (Exception e) {
            LogUtil.error(this.getClass(), "Login failed: ", e);
            return new AuthResponse(-1, "Failed");
        }
        return new AuthResponse(0, "OK", new Token(request.getUsername(), currentUser).getKey());
    }

}

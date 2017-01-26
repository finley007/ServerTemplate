package com.template.auth.impl;

import com.template.auth.AuthService;
import com.template.auth.response.AuthResponse;
import com.template.dao.AuthDao;
import com.template.dao.Module2Dao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by finley on 1/25/17.
 */
public class AuthServiceImpl implements AuthService {

    private AuthDao authDao;

    @Autowired(required = true)
    public void setAutoDao(AuthDao authDao) {
            this.authDao = authDao;
        }

    public AuthResponse authenticate(String username, String password) throws Exception {
        return 0;
    }

}

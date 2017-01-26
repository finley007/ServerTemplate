package com.template.auth;

import com.template.auth.response.AuthResponse;

/**
 * Created by finley on 1/23/17.
 */
public interface AuthService {

    public AuthResponse authenticate(String username, String password);

}

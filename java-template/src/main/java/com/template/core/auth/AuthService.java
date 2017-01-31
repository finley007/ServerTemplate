package com.template.core.auth;

import com.template.core.auth.request.AuthRequest;
import com.template.core.auth.response.AuthResponse;

/**
 * Created by finley on 1/23/17.
 */
public interface AuthService {

    public AuthResponse authenticate(AuthRequest request);

}

package com.template.auth;

import com.template.model.User;

import java.util.Set;

/**
 * Created by finley on 1/29/17.
 */
public interface UserService {

    public User getUserByName(String username);
    public Set<String> getRoles(String username);
    public Set<String> getPermissions(String username);

}

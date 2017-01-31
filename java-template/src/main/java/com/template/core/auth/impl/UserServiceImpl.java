package com.template.core.auth.impl;

import com.template.core.auth.UserService;
import com.template.dao.UserDao;
import com.template.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by finley on 1/29/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }
}

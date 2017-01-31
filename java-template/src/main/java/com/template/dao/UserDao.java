package com.template.dao;

import com.template.model.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by finley on 1/29/17.
 */
public interface UserDao {

    @Select("SELECT * from users t where t.username = #{username}")
    @Result(javaType = User.class)
    @Options(useCache = true)
    public User getUserByName(@Param("username") String username);

    @Select("select role from user_role t where t.user = #{username}")
    @Result(javaType = String.class)
    @Options(useCache = true)
    public Set<String> getRoles(@Param("username") String username);

    @Select("select 'permission' from user_role t where t.user = #{username}")
    @Result(javaType = String.class)
    @Options(useCache = true)
    public Set<String> getPermissions(@Param("username") String username);
}

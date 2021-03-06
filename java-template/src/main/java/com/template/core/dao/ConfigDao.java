package com.template.core.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by finley on 2/8/17.
 */
public interface ConfigDao {

    @Select("SELECT * from exception_code")
    @Result(javaType = Map.class)
    @Options(useCache = true)
    public List<Map> getExceptionCode();

}

package com.template.dao;

import com.template.model.Model2;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * Created by finley on 1/25/17.
 */
public class AuthDao {

    @Select("SELECT * from model2 t where t.field1 = #{field1}")
    @Result(javaType = Model2.class)
    @Options(useCache = true)
    public Model2 getModule2ById(@Param("field1") String field1);
}

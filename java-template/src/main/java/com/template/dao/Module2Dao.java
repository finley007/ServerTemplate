package com.template.dao;

import com.template.model.Model2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * Created by finley on 1/6/17.
 */
public interface Module2Dao {

    @Insert("INSERT INTO model2(field1,field2) VALUES(#{field1},#{field2})")
    @Options(useGeneratedKeys=true, keyProperty="field1", flushCache= Options.FlushCachePolicy.DEFAULT, keyColumn="field1")
    public void addModel2(Model2 model2);

}

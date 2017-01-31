package com.template.core.serialize;

import java.util.List;
import java.util.Map;

/**
 * Created by liuli on 11/7/2016.
 */
public interface Serializer {

    public String serializeFromBean(Object bean);

    public String serializeFromBean(Object bean, String[] _nory_changes, boolean nory);

    public String serializeFromBeanList(List beans);

    public String serializeFromBeanList(List beans, String[] _nory_changes, boolean nory);

    public String serializeFromMap(Map<String, ?> map, String[] _nory_changes, boolean nory);

    public String serializeFromList(List<?> list);

    public <T> T deserializeToBean(String jsonString, Class<T> beanClass);

    public Map deserializeToMap(String jsonString);

    public Object[] deserializeToArray(String jsonString);

    public <T> List<T> deserializeToList(String jsonString, Class<T> beanClass);

    public <T> T[] deserializeToArray(String jsonString, Class<T> clz);
}

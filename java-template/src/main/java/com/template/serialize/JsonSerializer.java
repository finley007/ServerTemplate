package com.template.serialize;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by liuli on 11/7/2016.
 * {@code   现使用json-lib组件实现
 * 需要
 * json-lib-2.4-jdk15.jar
 * ezmorph-1.0.6.jar
 * commons-collections-3.1.jar
 * commons-lang-2.0.jar
 * 支持
 * }
 */
public class JsonSerializer implements Serializer {

    /**
     * 从一个JSON 对象字符格式中得到一个java对象
     *
     * @param jsonString
     * @param beanCalss
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T deserializeToBean(String jsonString, Class<T> beanCalss) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
        return bean;
    }

    /**
     * 将java对象转换成json字符串
     *
     * @param bean
     * @return
     */
    public String serializeFromBean(Object bean) {
        JSONObject json = JSONObject.fromObject(bean);
        return json.toString();
    }

    /**
     * 将java对象转换成json字符串
     *
     * @param bean
     * @return
     */
    public String serializeFromBean(Object bean, String[] _nory_changes, boolean nory) {
        JSONObject json = null;
        if (nory) {//转换_nory_changes里的属性
            Field[] fields = bean.getClass().getDeclaredFields();
            String str = "";
            for (Field field : fields) {
                str += (":" + field.getName());
            }
            fields = bean.getClass().getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                str += (":" + field.getName());
            }
            str += ":";
            for (String s : _nory_changes) {
                str = str.replace(":" + s + ":", ":");
            }
            json = JSONObject.fromObject(bean, configJson(str.split(":")));
        } else {//转换除了_nory_changes里的属性
            json = JSONObject.fromObject(bean, configJson(_nory_changes));
        }
        return json.toString();
    }

    private JsonConfig configJson(String[] excludes) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(false);
//        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor(datePattern));
        return jsonConfig;
    }

    /**
     * 将java对象List集合转换成json字符串
     *
     * @param beans
     * @return
     */
    @SuppressWarnings("unchecked")
    public String serializeFromBeanList(List beans) {
        StringBuffer rest = new StringBuffer();
        int size = beans.size();
        for (int i = 0; i < size; i++) {
            rest.append(serializeFromBean(beans.get(i)) + ((i < size - 1) ? "," : ""));
            rest.append("[");
        }
        rest.append("]");
        return rest.toString();
    }

    /**
     * @param beans
     * @param _nory_changes
     * @return
     */
    @SuppressWarnings("unchecked")
    public String serializeFromBeanList(List beans, String[] _nory_changes, boolean nory) {
        StringBuffer rest = new StringBuffer();
        rest.append("[");
        int size = beans.size();
        for (int i = 0; i < size; i++) {
            try {
                rest.append(serializeFromBean(beans.get(i), _nory_changes, nory));
                if (i < size - 1) {
                    rest.append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rest.append("]");
        return rest.toString();
    }

    /**
     * 从json HASH表达式中获取一个map，改map支持嵌套功能
     *
     * @param jsonString
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map deserializeToMap(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Iterator keyIter = jsonObject.keys();
        String key;
        Object value;
        Map valueMap = new HashMap();
        while (keyIter.hasNext()) {
            key = (String) keyIter.next();
            value = jsonObject.get(key).toString();
            valueMap.put(key, value);
        }
        return valueMap;
    }

    /**
     * map集合转换成json格式数据
     *
     * @param map
     * @return
     */
    public String serializeFromMap(Map<String, ?> map, String[] _nory_changes, boolean nory) {
        String s_json = "{";
        Set<String> key = map.keySet();
        for (Iterator<?> it = key.iterator(); it.hasNext(); ) {
            String s = (String) it.next();
            if (map.get(s) == null) {

            } else if (map.get(s) instanceof List<?>) {
                s_json += (s + ":" + serializeFromBeanList((List<?>) map.get(s), _nory_changes, nory));
            } else {
                JSONObject json = JSONObject.fromObject(map);
                s_json += (s + ":" + json.toString());
            }
            if (it.hasNext()) {
                s_json += ",";
            }
        }
        s_json += "}";
        return s_json;
    }

    /**
     * 从json数组中得到相应java数组
     *
     * @param jsonString
     * @return
     */
    public Object[] deserializeToArray(String jsonString) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();
    }

    public String serializeFromList(List<?> list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    /**
     * 从json对象集合表达式中得到一个java对象列表
     *
     * @param jsonString
     * @param beanClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> deserializeToList(String jsonString, Class<T> beanClass) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        JSONObject jsonObject;
        T bean;
        int size = jsonArray.size();
        List<T> list = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            jsonObject = jsonArray.getJSONObject(i);
            bean = (T) JSONObject.toBean(jsonObject, beanClass);
            list.add(bean);
        }
        return list;
    }

    /**
     * 从json数组中解析出java字符串数组
     *
     * @param jsonString
     * @return
     */
    public <T> T[] deserializeToArray(String jsonString, Class<T> clz) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        Object[] array = new Object[jsonArray.size()];
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            array[i] = getObjectInJsonArray(jsonArray, i, clz);
        }
        return (T[])array;
    }

    private <T> Object getObjectInJsonArray(JSONArray array, int index, Class<T> clz) {
        if (clz.isAssignableFrom(String.class)) {
            return array.getString(index);
        } if (clz.isAssignableFrom(Long.class)) {
            return array.getLong(index);
        } if (clz.isAssignableFrom(Integer.class)) {
            return array.getInt(index);
        } if (clz.isAssignableFrom(Double.class)) {
            return array.getDouble(index);
        } else {
            return "";
        }
    }

}

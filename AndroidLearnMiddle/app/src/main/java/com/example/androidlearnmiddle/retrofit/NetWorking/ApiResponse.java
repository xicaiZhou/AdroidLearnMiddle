package com.example.androidlearnmiddle.retrofit.NetWorking;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by ljy on 2018/3/16.
 */

public class ApiResponse implements Serializable {

    private String reason;
    private int resultcode;
    private String result;
    private Object object;


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getObject() {
        if (object == null) {
            object = new Object();
        }
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 失败返回null
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(Class<T> clazz) {
        if (result != null) {
            try {
                return Util.getGson().fromJson(result, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 失败返回null
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(Class<T> clazz, T defaultValue) {
        if (result != null) {
            T t = null;
            try {
                t = Util.getGson().fromJson(result, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (t == null) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /**
     * 如果data里是数组，直接这样获取
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getDatas(Class<T> clazz) {
        if (result == null) {
            return null;
        }
        Gson gson = Util.getGson();
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(result).getAsJsonArray();
        for (int i = 0; i < array.size(); i++) {
            list.add(gson.fromJson(array.get(i), clazz));
        }
        return list;
    }

    @Override
    public String toString() {
        return Util.getGson().toJson(this);
    }

}

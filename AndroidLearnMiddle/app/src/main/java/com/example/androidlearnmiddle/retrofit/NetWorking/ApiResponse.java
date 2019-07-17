package com.example.androidlearnmiddle.retrofit.NetWorking;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.androidlearnmiddle.retrofit.NetWorking.Util;
/**
 * Created by ljy on 2018/3/16.
 */

public class ApiResponse implements Serializable {

    private String msg;
    private int code;
    private String data;
    private Object object;


    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        if (data != null) {
            try {
                return Util.getGson().fromJson(data, clazz);
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
        if (data != null) {
            T t = null;
            try {
                t = Util.getGson().fromJson(data, clazz);
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
        if (data == null) {
            return null;
        }
        Gson gson = Util.getGson();
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(data).getAsJsonArray();
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

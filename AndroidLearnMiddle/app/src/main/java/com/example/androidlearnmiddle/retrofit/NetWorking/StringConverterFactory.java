package com.example.androidlearnmiddle.retrofit.NetWorking;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class StringConverterFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class) {
            return new StringConverter();
        } else if(type == ApiResponse.class) {
            //其它类型我们不处理，返回null就行
            return new BaseMessageConverter();
        }
        return null;
    }

    public class StringConverter implements Converter<ResponseBody, String> {

        @Override
        public String convert(ResponseBody value) throws IOException {
            return value.string();
        }
    }

    public class BaseMessageConverter implements Converter<ResponseBody, ApiResponse> {

        @Override
        public ApiResponse convert(ResponseBody value) throws IOException {
            String json = value.string();
//            String json = decrypt(string);
            ApiResponse jisuResponse = JSONObject.parseObject(json, ApiResponse.class);
            return jisuResponse;
        }

    }

}

package com.example.androidlearnmiddle.cache;


import com.example.androidlearnmiddle.other.easycache.Cache;
import com.example.androidlearnmiddle.other.easycache.EasySpCache;
import com.example.androidlearnmiddle.other.easycache.Key;
import com.example.androidlearnmiddle.other.easycache.LoadCache;

/**
 * SharePreference封装类EasyCache的代理接口
 * Created by billyyoyo on 16-1-19.
 */
@EasySpCache(name = "configuration_cache")
public interface ConfigCacheProxy {

    @Cache
    void cacheConfiguration(@Key(value = "configuration") ConfigCache config);

    @LoadCache(key = "configuration", getClassType = ConfigCache.class)
    ConfigCache loadConfiguragion();

}

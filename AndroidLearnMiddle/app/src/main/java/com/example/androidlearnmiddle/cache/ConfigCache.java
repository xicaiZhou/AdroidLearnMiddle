package com.example.androidlearnmiddle.cache;

import android.text.TextUtils;

import com.example.androidlearnmiddle.other.easycache.EasyCacheManager;


/**
 * Created by billyyoyo on 16-1-27.
 */
public class ConfigCache {

    public String APP;

    public String httpCache;

    public long loginUserId = 0l;

    public String token;

    public synchronized static ConfigCache get() {
        if (CacheStub.getInstance().getConfigCache() == null) {
            loadCacheProxy();
            CacheStub.getInstance().setConfigCache(CacheStub.getInstance().getConfigCacheProxy().loadConfiguragion());
        }
        if (CacheStub.getInstance().getConfigCache() == null) {
            CacheStub.getInstance().setConfigCache(new ConfigCache());
        }
        return CacheStub.getInstance().getConfigCache();
    }

    public static void save() {
        loadCacheProxy();
        CacheStub.getInstance().getConfigCacheProxy().cacheConfiguration(CacheStub.getInstance().getConfigCache());
    }

    private static synchronized void loadCacheProxy() {
        if (CacheStub.getInstance().getConfigCacheProxy() == null) {
            CacheStub.getInstance().setConfigCacheProxy(EasyCacheManager.getInstance().getCacheProxy().create(ConfigCacheProxy.class));
        }
    }

    public static boolean isLogined() {
        return !TextUtils.isEmpty(get().token);
    }

}

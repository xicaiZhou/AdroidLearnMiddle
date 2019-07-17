package com.example.androidlearnmiddle.other.easycache;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 37X21=777 on 15/9/23.
 */
public final class CacheProxy {

    public <T> T create(Class<T> service) {
        Utils.validateServiceClass(service);
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new CacheHandler(service));
    }

    private class CacheHandler implements InvocationHandler {

        private Class<?> service;
        private String name;

        public CacheHandler(Class<?> service) {
            this.service = service;
            this.name = EasyCacheManager.getInstance().getCacheName(this.service);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Annotation methodAnnotation : method.getAnnotations()) {
                Class<? extends Annotation> annotationType = methodAnnotation.annotationType();
                if (annotationType == LoadCache.class) {
                    String key = ((LoadCache) methodAnnotation).key();
                    Class clazz = ((LoadCache) methodAnnotation).getClassType();
                    return EasyCacheManager.getInstance().loadCache(name, key, clazz);
                } else if (annotationType == Cache.class) {
                    Annotation[][] parameterAnnotationArrays = method.getParameterAnnotations();
                    if (parameterAnnotationArrays.length > 0) {
                        Annotation[] parameterAnnotations = parameterAnnotationArrays[0];
                        if (parameterAnnotations != null && parameterAnnotations.length > 0) {
                            Annotation parameterAnnotation = parameterAnnotations[0];
                            Class<? extends Annotation> innerAnnotationType = parameterAnnotation.annotationType();
                            if (innerAnnotationType == Key.class) {
                                String key = ((Key) parameterAnnotation).value();
                                EasyCacheManager.getInstance().cache(name, key, Utils.gson.toJson(args[0]));
                            }
                        }
                    }
                } else if (annotationType == RemoveKey.class) {
                    String key = ((RemoveKey) methodAnnotation).key();
                    EasyCacheManager.getInstance().removeKey(name, key);
                } else if (annotationType == Clear.class) {
                    EasyCacheManager.getInstance().clear(name);
                }
            }
            return null;
        }
    }
}

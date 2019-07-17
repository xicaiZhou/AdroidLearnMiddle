package com.example.androidlearnmiddle.other.easycache;

import android.util.Log;

import com.google.gson.Gson;

import fun.flyee.sunshine4u.android.utils.CLog;

/**
 * Created by 37X21=777 on 15/9/23.
 */

final class Utils {

    static <T> void validateServiceClass(Class<T> service) {
        if (!service.isInterface()) {
            throw new IllegalArgumentException("Only interface endpoint definitions are supported.");
        }

        if (service.getInterfaces().length > 0) {
            throw new IllegalArgumentException("Interface definitions must not extend other interfaces.");
        }
    }

    private Utils() {
        // No instances.
    }

    public static Gson gson = new Gson();

    public static void logError(String msg) {
        CLog.e("EasyCache:", msg);
    }
}


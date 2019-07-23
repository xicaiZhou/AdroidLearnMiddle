package com.example.androidlearnmiddle.retrofit.NetWorking;

import com.alibaba.fastjson.JSONObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class  HttpObserver implements Observer<ApiResponse> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ApiResponse apiResponse) {
        if(apiResponse.getResultcode() == 200) {
            onResult(true, apiResponse);
        }else if(apiResponse.getResultcode() == 99999){
            onResult(false, apiResponse);
//            EventBus.getDefault().post(new AppUpgradeEvent(""));
        }else {
            onResult(false, apiResponse);
        }
    }

    @Override
    public void onError(Throwable e) {
//        onResult(false, null, e);
        try {
            if (e instanceof Exception) {
                //访问获得对应的Exception
                ExceptionHandle.ResponeThrowable throwable = ExceptionHandle.handleException(e);

                ApiResponse response = null;
                if (throwable.message.startsWith("{")) {//json
                    response = JSONObject.parseObject(throwable.message, ApiResponse.class);
                } else if (throwable.message.trim().startsWith("<html>") || throwable.message.trim().startsWith("<!DOCTYPE html>") || throwable.message.trim().endsWith("</html>")) {//html error
                } else {//尝试解密

                }
                if (response == null) {
                    response = new ApiResponse();
                    response.setReason(throwable.message);
                }
                //token 过期
                if (throwable.code == 401) {
//                    EventBus.getDefault().post(new LogoutEvent());
                }

                if (response.getResultcode() == 0)
                    response.setResultcode(throwable.code);
//                LogUtil.println("sheepApi", "onError", e.getMessage(), throwable.message, baseMessage);
                onResult(false, response);
            } else {
                ApiResponse response = new ApiResponse();
                response.setReason(e.getMessage());
                response.setResultcode(ExceptionHandle.ERROR.UNKNOWN);
                onResult(false, response);
            }
        } catch (Exception er) {
            ApiResponse baseMessage = new ApiResponse();
            baseMessage.setReason(er.getMessage());
            baseMessage.setResultcode(ExceptionHandle.ERROR.UNKNOWN);
            onResult(false, baseMessage);
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onResult(boolean ret, ApiResponse apiResponse);
}

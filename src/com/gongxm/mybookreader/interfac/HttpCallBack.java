package com.gongxm.mybookreader.interfac;

/**
 * 网络请求接口
 * @author gongxm
 *
 */
public interface HttpCallBack {
public abstract void responseSuccess(int statusCode, String result);//请求成功
public abstract void responseFail(int statusCode);//请求失败
}

package com.gongxm.mybookreader.interfac;

/**
 * ��������ӿ�
 * @author gongxm
 *
 */
public interface HttpCallBack {
public abstract void responseSuccess(int statusCode, String result);//����ɹ�
public abstract void responseFail(int statusCode);//����ʧ��
}

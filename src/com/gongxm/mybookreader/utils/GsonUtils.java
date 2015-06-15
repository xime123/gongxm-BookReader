package com.gongxm.mybookreader.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**
 * ����json�Ĺ�����
 * 
 * @author gongxm
 * 
 */
public class GsonUtils {
	private static Gson gson = new Gson();

	//����תjson
	public static <T> String toJson(T t) {
		String json="{}";
		try {
			json = gson.toJson(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	//jsonת����
	public static <T> T fromJson(String json,Type type){
		T t=null;
		try {
			t = gson.fromJson(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}

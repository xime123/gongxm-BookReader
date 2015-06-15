package com.gongxm.mybookreader.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.text.TextUtils;
import android.widget.ImageView;

import com.gongxm.mybookreader.interfac.HttpCallBack;

/**
 * �������󹤾�
 * 
 * @author gongxm
 * 
 */
public class HttpUtils {

	/**
	 * ִ��GET����
	 * 
	 * @param url
	 * @return
	 */
	public static void executeGet(final String url, final HttpCallBack callBack) {
		Runnable task = new Runnable() {
			public void run() {

				try {
					HttpClient client = new DefaultHttpClient();
					HttpGet get = new HttpGet(url);
					HttpResponse response = client.execute(get);
					int statusCode = response.getStatusLine().getStatusCode();
					if (statusCode >= 200 && statusCode < 400) {
						HttpEntity entity = response.getEntity();
						String json = StreamUtils.readStream(
								entity.getContent(), "ISO-8859-1");
						if (json.startsWith("{")) {
							json = new String(json.getBytes("ISO-8859-1"),
									"UTF-8");
						} else {
							String encoding = GetEncoding(json);
							if (!TextUtils.isEmpty(encoding)) {
								json = new String(json.getBytes("ISO-8859-1"),
										encoding);
							} else {
								json = new String(json.getBytes("ISO-8859-1"),
										"GBK");
							}
						}
						if (callBack != null) {
							callBack.responseSuccess(statusCode, json);
						}
					} else {
						if (callBack != null) {
							callBack.responseFail(statusCode);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					callBack.responseFail(AppConstants.ERROR);
				}
			}
		};
		ThreadPoolUtil.executeOnNewThread(task);
	}

	// ������ҳ��HTML������ȡ��ҳ��Encoding
	private static String GetEncoding(String html) {
		String pattern = "charset=\"?([-a-zA-Z_0-9]+)";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(html);
		String charset = null;
		if (matcher.find()) {
			charset = matcher.group().substring(8).replace("\"", "");
		}
		return charset;
	}

	/**
	 * ִ��POST����
	 * 
	 * @param url
	 *            ����ĵ�ַ
	 * @param data
	 *            ���������
	 * @param callBack
	 *            ����ص�
	 */
	public static void executePost(final String url, final String data,
			final HttpCallBack callBack) {
		Runnable task = new Runnable() {
			public void run() {
				try {
					HttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(url);
					HttpEntity entity = new StringEntity(data);
					post.setEntity(entity);
					HttpResponse response = client.execute(post);
					int statusCode = response.getStatusLine().getStatusCode();
					if (statusCode >= 200 && statusCode < 400) {
						HttpEntity result = response.getEntity();
						String json = StreamUtils.readStream(
								result.getContent(), "UTF-8");
						if (callBack != null) {
							callBack.responseSuccess(statusCode, json);
						}
					} else {
						if (callBack != null) {
							callBack.responseFail(statusCode);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					callBack.responseFail(AppConstants.ERROR);
				}
			}
		};

		ThreadPoolUtil.executeOnNewThread(task);
	}

	private static MyImageLoader loader = new MyImageLoader();

	/**
	 * ����ͼƬ
	 * 
	 * @param container
	 * @param url
	 */
	public static void loadImage(ImageView container, String url) {
		loader.display(container, url);
	}
}

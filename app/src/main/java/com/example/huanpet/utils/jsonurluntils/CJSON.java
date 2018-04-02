package com.example.huanpet.utils.jsonurluntils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CJSON {

    private static final String START_BRACES = "{";
    private static final String END_BRACES = "}";
    private static final String START_CONTENT = "\"";
    private static final String END_CONTENT = "\"";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    public static final String TOKEN = "token";

    public static final String HEADER = "header";
    /**
     * data
     */
    public static final String DATA = "channel";
    /**
     * JSON内容
     */
    public static final String BODY = "body";
    /**
     * 平台
     */
    public static final String CHANNEL = "channel";
    private static StringBuffer json;
    private static String userdata;

    public static String buildJSON(Context context, Map<String, Object> params) {
        json = new StringBuffer();
        json.append(START_BRACES + START_CONTENT);
        json.append(HEADER + END_CONTENT + COLON);
        json.append(START_BRACES);
        json.append(START_CONTENT + SignUtil.SIGN + END_CONTENT + COLON + START_CONTENT + SignUtil.getSign(createLinkString(params)) + END_CONTENT);
        json.append(COMMA);
        json.append(START_CONTENT + ConnectionUtils.IP + END_CONTENT + COLON + START_CONTENT + ConnectionUtils.getIp(context) + END_CONTENT);
        json.append(COMMA);
        json.append(START_CONTENT + DATA + END_CONTENT + COLON + START_CONTENT + "android" + END_CONTENT);
        json.append(COMMA);
        json.append(START_CONTENT + TOKEN + END_CONTENT + COLON + START_CONTENT + CJSON.createToken(context) + END_CONTENT);
        json.append(END_BRACES + COMMA);
        json.append(START_CONTENT + BODY + END_CONTENT);
        json.append(COLON);
        json.append(START_BRACES);
        if (params != null) {
            List<String> keys = new ArrayList<String>(params.keySet());
            int count = keys.size();
            for (int i = 0; i < count; i++) {
                if (params.get(keys.get(i)) != null) {
                    if (params.get(keys.get(i)).equals("null")
                            || params.get(keys.get(i)).equals("0")) {
                        count--;
                        continue;
                    }
                    Log.e("buildJSON: ", keys.get(i) + "-------------------------------------------");
                    json.append(START_CONTENT + keys.get(i) + END_CONTENT + COLON + START_CONTENT + params.get(keys.get(i)) + END_CONTENT);
                    if (!(i == count - 1))
                        json.append(COMMA);
                }
            }
        }

        json.append(END_BRACES + END_BRACES);
        Log.e("buildJSON: ", "-----------------" + json.toString());
        return json.toString();
    }

    public static String createToken(Context context) {
        // 生成的token
        String token = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        token = ConnectionUtils.getIp(context) + sdf.format(date) + "CD";

        token = Md5Encrypt.md5(token, "utf-8");

        return token;
    }

    public static String createLinkString(Map<String, Object> params) {
        if (params == null) {
            return "";
        }
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        StringBuffer prestr = new StringBuffer();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = null;
            if (params.get(key) == null) {
                continue;
            } else {
                value = params.get(key);
            }

            if (params.get(key) instanceof String
                    || params.get(key) instanceof Integer
                    || params.get(key) instanceof BigDecimal
                    || params.get(key) instanceof Double
                    || params.get(key) instanceof Long) {
                if (i == keys.size() - 1) {// 拼接时，不包括最后一�?&字符
                    prestr.append(key + "=" + value);
                } else {
                    prestr.append(key + "=" + value + "&");
                }
            }
        }
        return prestr.toString();
    }

    public static void getData(final Context context, final String urldata, final Map<String, Object> bodyparams, final Handler handler) {
        new Thread(new Runnable() {

            public void run() {
                String s = CJSON.buildJSON(context, bodyparams);
                // 生成提交服务器的JSON字符串
                final FormBody data = new FormBody.Builder().add("data", s).build();

                OkHttpClient client = new OkHttpClient();
                Request url = new Request.Builder().url("http://123.56.150.230:8885/dog_family/" + urldata).post(data).build();

                client.newCall(url).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("onFailure: ", e.getMessage() + "-----------------");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        handler.obtainMessage(0, response.body().string()).sendToTarget();


                    }
                });
            }
        }).start();


    }
}



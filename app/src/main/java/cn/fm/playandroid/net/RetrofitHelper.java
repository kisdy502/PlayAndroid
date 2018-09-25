package cn.fm.playandroid.net;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.fm.playandroid.base.Constant;
import cn.fm.playandroid.log.ELog;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2018/9/21.
 */

public class RetrofitHelper {
    private final static String TAG = "RetrofitHelper";
    private final static String CONTENT_PRE = "OkHttp: ";
    private final static String SAVE_USER_LOGIN_KEY = "user/login";
    private final static String SAVE_USER_REGISTER_KEY = "user/register";
    private final static String SET_COOKIE_KEY = "set-cookie";
    private final static String COOKIE_NAME = "Cookie";
    private final static long CONNECT_TIMEOUT = 30L;
    private final static long READ_TIMEOUT = 10L;


    public static RetrofitService getRetrofitService() {
        return create(Constant.REQUEST_BASE_URL).create(RetrofitService.class);
    }

    private static Retrofit create(String url) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(cookInterceptor);

        if (Constant.INTERCEPTOR_ENABLE) {
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(logInterceptor);
        }
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    static HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            try {
                String text = URLDecoder.decode(message, "utf-8");
                ELog.e("OKHttp-----", text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                ELog.e("OKHttp-----", message);
            }
        }
    });

    private static Interceptor cookInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            String requestUrl = request.url().toString();
            String domain = request.url().host();
            if ((requestUrl.contains(SAVE_USER_LOGIN_KEY)
                    || requestUrl.contains(SAVE_USER_REGISTER_KEY))
                    && !response.headers(SET_COOKIE_KEY).isEmpty()) {
                List<String> cookies = response.headers(SET_COOKIE_KEY);
                //TODO save cookie
            }
            return response;
        }
    };


}

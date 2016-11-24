/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.niray.apply;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 2015-08-07T03:57:47.229Z
 * Created by drakeet on 8/9/15.
 */
public class DrakeetRetrofit {

    final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();
    final GankApi gankService;

    DrakeetRetrofit() {

        Interceptor mTokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request originalRequest = chain.request();
//                if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
//                    return chain.proceed(originalRequest);
//                }
                Request authorised = originalRequest.newBuilder().header("Authorization", "Your.sToken").build();
                return chain.proceed(authorised);
            }
        };

        Authenticator mAuthenticator = new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
//                Your.sToken = service.refreshToken();
                return response.request().newBuilder().addHeader("Authorization", "newAccessToken").build();
            }
        };

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(mTokenInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.huway.com")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        gankService = retrofit.create(GankApi.class);

//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.baseUrl(new OkHttpClient(client))
//                .setLogLevel(Retrofit.LogLevel.FULL)
//                .setEndpoint("https://api.huway.com")//http://gank.io/api
//                .setConverter(new GsonConverter(gson));
//
//        Retrofit gankRestAdapter = builder.build();
        //builder.setEndpoint("https://leancloud.cn:443/1.1/classes");

    }

//    public static OkHttpClient genericClient() {
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Interceptor.Chain chain) throws IOException {
//                        Request request = chain.request()
//                                .newBuilder()
//                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                .addHeader("Accept-Encoding", "gzip, deflate")
//                                .addHeader("Connection", "keep-alive")
//                                .addHeader("Accept", "*/*")
//                                .addHeader("Cookie", "add cookies here")
//                                .build();
//                        return chain.proceed(request);
//                    }
//
//                })
//                .build();
//
//        return httpClient;
//    }

    public GankApi getGankService() {
        return gankService;
    }
}

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

package org.niray.czndroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

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
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setClient(new OkClient(client))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.huway.com")//http://gank.io/api
                .setConverter(new GsonConverter(gson));
        RestAdapter gankRestAdapter = builder.build();
        //builder.setEndpoint("https://leancloud.cn:443/1.1/classes");
        gankService = gankRestAdapter.create(GankApi.class);
    }

    public GankApi getGankService() {
        return gankService;
    }

}

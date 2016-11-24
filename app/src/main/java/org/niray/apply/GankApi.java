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

import org.niray.apply.bean.GankData;
import org.niray.apply.bean.LineListData;
import org.niray.apply.bean.MeizhiData;
import org.niray.apply.bean.VideoData;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GankApi {

    @GET("/data/福利/" + DrakeetFactory.meizhiSize + "/{page}")
    Observable<MeizhiData> getMeizhiData(
            @Path("page") int page);

    @GET("/day/{year}/{month}/{day}")
    Observable<GankData> getGankData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day);

    @GET("/data/休息视频/" + DrakeetFactory.meizhiSize + "/{page}")
    Observable<VideoData> getVideoData(@Path("page") int page);

    @Headers({"request-source: 3"})
    @GET("/event/line/list?pagesize=3")
    Observable<LineListData> getLineList(@Query("page") int page);

}

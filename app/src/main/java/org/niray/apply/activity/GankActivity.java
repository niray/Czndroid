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

package org.niray.apply.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import org.niray.apply.DrakeetFactory;
import org.niray.apply.GankApi;
import org.niray.apply.bean.LineListData;
import org.niray.apply.bean.Meizhi;
import org.niray.apply.bean.MeizhiData;
import org.niray.apply.bean.VideoData;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GankActivity extends Activity {

    public static final GankApi sGankIO = DrakeetFactory.getGankIOSingleton();

    private List<Meizhi> mMeizhiList = new ArrayList<>();
    private int mPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadData(true);
        loadLineList(1);
    }

    private void loadLineList(int p) {
        sGankIO.getLineList(p).filter(j -> j.getData() != null)
                .map(json -> json.getData().getData())
                .filter(this::filterJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //    .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<LineListData.LineListDetail>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<LineListData.LineListDetail> lineListDetails) {
                        List<LineListData.LineListDetail> lineList = new ArrayList<>();
                        lineList.addAll(lineListDetails);
                    }
                });
//                        (dGank -> {
//                }, throwable -> loadError(throwable));
    }

    private Boolean filterJson(List<LineListData.LineListDetail> lineListDetails) {
        return (lineListDetails.size() > 0);
    }

    private void loadData(boolean clean) {
        Subscription s = Observable.zip(sGankIO.getMeizhiData(mPage), sGankIO.getVideoData(mPage), this::createMeizhiDataWith休息视频Desc)
                .map(meizhiData -> meizhiData.results)
                .flatMap(Observable::from)
                .toSortedList((meizhi1, meizhi2) ->
                        meizhi2.publishedAt.compareTo(meizhi1.publishedAt))
                .doOnNext(this::saveMeizhis)
                .observeOn(AndroidSchedulers.mainThread())
                .finallyDo(() -> toast("finally"))
                .subscribe(meizhis -> {
                    if (clean) mMeizhiList.clear();
                    mMeizhiList.addAll(meizhis);
                }, throwable -> loadError(throwable));
//        addSubscription(s);
    }

    private void saveMeizhis(List<Meizhi> meizhis) {
    }

    private void donext(List<Meizhi> meizhis) {
        toast(meizhis.toString());
    }

    private MeizhiData createMeizhiDataWith休息视频Desc(MeizhiData data, VideoData love) {
        return data;
    }

    void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
    }

}

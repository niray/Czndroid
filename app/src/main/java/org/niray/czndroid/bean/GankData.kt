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

package org.niray.czndroid.bean

/**
 * Created by drakeet on 8/11/15.
 */
class GankData() {

    var results: Result? = null
    var category: List<String>? = null

    inner class Result {
        var androidList: List<Gank>? = null
        var 休息视频List: List<Gank>? = null
        var iOSList: List<Gank>? = null
        var 妹纸List: List<Gank>? = null
        var 拓展资源List: List<Gank>? = null
        var 瞎推荐List: List<Gank>? = null
        var appList: List<Gank>? = null
    }
}

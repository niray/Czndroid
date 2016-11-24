package org.niray.apply;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface HttpService {

    @GET
    Call<ResponseBody> urlRequest(@Url String url);

}

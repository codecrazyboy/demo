package com.example.administrator.mvpdemo.service;



import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Smart;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 * http://gank.io/api/data/Android/10/1
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);
    @GET("book/search")
    Observable<Admin> getSearchAdmins(@Query("q") String name,
                                      @Query("tag") String tag, @Query("start") int start,
                                      @Query("count") int count);
    @GET ("api/data/{type}/{pageSize}/{pageNumber}")
    Observable<Smart> getSearchSmarts(@Path("type") String type,
                                      @Path("pageSize")  int pageSize,
                                        @Path("pageNumber") int pageNumber);
}

package com.example.gituserapp.Retrofit;

import com.example.gituserapp.Response.Items;
import com.example.gituserapp.Response.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/users")
    @Headers("Authorization: Bearer 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")
    Call<Response> callUser(@Query("q") String username);

    @GET("users/{username}")
    Call<Items> callDetailUser(@Path("username") String username);

}

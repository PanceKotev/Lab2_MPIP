package com.laboratoriski.lab2.client;

import com.laboratoriski.lab2.repository.OMDBService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OMDBApiClient {
    private static Retrofit retrofit=null;
    private static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("http://www.omdbapi.com/").addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
    public static OMDBService getService(){
        return getRetrofit().create(OMDBService.class);
    }
}

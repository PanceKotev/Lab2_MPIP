package com.laboratoriski.lab2.repository;

import com.laboratoriski.lab2.models.OMovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OMDBService {
    @GET("")
    Call<OMovie> getMovie(@Query("t") String movie);
}

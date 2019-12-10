package com.laboratoriski.lab2.asynctask;

import android.os.AsyncTask;
import com.laboratoriski.lab2.client.OMDBApiClient;
import com.laboratoriski.lab2.models.OMovie;
import com.laboratoriski.lab2.repository.MoviesRepo;
import retrofit2.Call;

import java.io.IOException;

public class OMovieAsyncTask extends AsyncTask<String,Integer, OMovie> {
    MoviesRepo repository;

    public OMovieAsyncTask(MoviesRepo repository) {
        this.repository = repository;
    }

    @Override
    protected OMovie doInBackground(String... strings) {
        final Call<OMovie> movie= OMDBApiClient.getService().getMovie(strings[0]);
        try {
           return movie.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(OMovie oMovie) {
        repository.insert(oMovie);
    }
}

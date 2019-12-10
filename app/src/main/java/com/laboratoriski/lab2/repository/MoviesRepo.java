package com.laboratoriski.lab2.repository;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Room;
import com.laboratoriski.lab2.models.OMovie;

public class MoviesRepo {
    private static MoviesDatabase database= null;
    public MoviesRepo(Context context){
        if(database==null){
            database= Room.databaseBuilder(context,MoviesDatabase.class,"db-app").build();
        }

    }
    public void insert(final OMovie om){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.getMovDao().insert(om);
                return null;
            }
        }.execute();
    }

    public void deleteAll(){
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                database.getMovDao().deleteAll();
                return null;
            }
        }.execute();
    }
}

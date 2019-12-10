package com.laboratoriski.lab2.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.laboratoriski.lab2.models.OMovie;

@Database(entities = {OMovie.class},version = 1)
public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MoviesApiDao getMovDao();
}

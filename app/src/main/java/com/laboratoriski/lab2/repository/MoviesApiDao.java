package com.laboratoriski.lab2.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.laboratoriski.lab2.models.OMovie;

import java.util.List;

@Dao
public interface MoviesApiDao {
    @Query("SELECT * FROM Movies")
    public List<OMovie> getMovies();

    @Insert
    public void insert(OMovie ...omovies);

    @Query("SELECT * FROM Movies WHERE imdbID=:id")
    public OMovie findByID(String id);

    @Query("DELETE from Movies")
    public void deleteAll();
    @Update
    public void Update();
    @Query("DELETE from Movies WHERE imdbID=:id")
    public void delete(String id);

    @Query("SELECT * FROM Movies")
    public LiveData<List<OMovie>> getMoviesAsync();

}

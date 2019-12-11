package com.laboratoriski.lab2.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.laboratoriski.lab2.models.OMovie;
import com.laboratoriski.lab2.repository.MoviesRepo;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MoviesRepo repository;
    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository=new MoviesRepo(application);
    }
    public MoviesRepo getRepository(){
        return repository;
    }
    public LiveData<List<OMovie>> getAllMov(){
        return repository.getAllMovies();
    }
}

package com.laboratoriski.lab2;

import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.laboratoriski.lab2.asynctask.OMovieAsyncTask;
import com.laboratoriski.lab2.client.OMDBApiClient;
import com.laboratoriski.lab2.models.OMovie;
import com.laboratoriski.lab2.repository.MoviesRepo;
import com.laboratoriski.lab2.viewmodels.MovieViewModel;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class MoviesActivity extends AppCompatActivity{
    MoviesRepo repository;
    private MovieViewModel movieViewModel;
    Logger logger= Logger.getLogger("MoviesActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        movieViewModel= ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getAllMov().observe(this, new Observer<List<OMovie>>() {
            @Override
            public void onChanged(List<OMovie> oMovies) {
                //Update RecyclerView
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.custom_menu,menu);
        SearchView searchView=(SearchView)menu.findItem(R.id.search_item).getActionView();
        searchView.setOnQueryTextListener(getOnQueryTextListener());
        return true;
    }
    private SearchView.OnQueryTextListener getOnQueryTextListener() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                logger.info("Query text submitted: " + query);
                OMovieAsyncTask task=new OMovieAsyncTask(repository);
                task.execute();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        };
    }

}

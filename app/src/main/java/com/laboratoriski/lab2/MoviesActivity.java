package com.laboratoriski.lab2;

import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import com.laboratoriski.lab2.client.OMDBApiClient;
import com.laboratoriski.lab2.models.OMovie;
import com.laboratoriski.lab2.repository.MoviesRepo;

import java.io.IOException;
import java.util.logging.Logger;

public class MoviesActivity extends AppCompatActivity{
    MoviesRepo repository;
    Logger logger= Logger.getLogger("MoviesActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        };
    }

}
